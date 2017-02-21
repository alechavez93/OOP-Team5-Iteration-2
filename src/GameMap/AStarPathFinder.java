package GameMap;

import Utility.Direction;
import Utility.Vec2i;

import java.util.*;

/*--------------------------------------------------------------------------------------
|   GameMap.AStarPathFinder Class: Created by Andrew on 2/4/2017.
|---------------------------------------------------------------------------------------
|   Description: Represents a A* algorithem for finding the path between
|   locations on the GameMap
|---------------------------------------------------------------------------------------*/

public class AStarPathFinder implements PathFinder {

    //private GameMap map;

    private class Node implements Comparable<Node>{
        public int sCost;
        public int eCost;
        public Vec2i loc;
        public Node cameFrom;

        public Node(int sCost, int eCost, Vec2i loc) {
            this.sCost = sCost;
            this.eCost = eCost;
            this.loc = loc;
        }

        public int compareTo(Node o2) {
            return eCost - o2.eCost;
        }
    }


    public Path createPath(MapCoordinate startCoord, MapCoordinate endCoord) {
        //Clump of initializations
        GameMap map = GameMap.getInstance();
        Vec2i start = startCoord.getVector();
        Vec2i end = endCoord.getVector();
        Queue<Node> closed = new PriorityQueue<Node>();
        Queue<Node> open = new PriorityQueue<Node>();

        open.add(new Node(0, distanceHeuristic(start, end), start));
        Vec2i size = map.getSize();
        Node[][] nodeMatrix = new Node[size.y][size.x];
        while(!open.isEmpty()) {
            Node n = open.poll();
            if(n.loc.x == end.x && n.loc.y == end.y) {
                //Path successfully calculated
                Stack<Direction> path = new Stack<Direction>();
                while(n.cameFrom != null) {
                    path.add(findDirection(n.cameFrom.loc, n.loc));
                    n = n.cameFrom;
                }
                return new Path(path, startCoord, endCoord);
            }

            closed.add(n);
            Tile[] neighbors = map.getAllNeighbors(n.loc);
            for(byte iii = 0; iii < neighbors.length; iii++) {
                Tile nn = neighbors[iii];

                //Not a sane neighbor
                if (nn == null)
                    continue;

                //Retrieve neighbor from location or create if none exists
                Vec2i nv = nn.getPos().getVector();
                Node nNode;
                if (nodeMatrix[nv.x][nv.y] != null) {
                    nNode = nodeMatrix[nv.x][nv.y];
                } else {
                    nNode = new Node(-1, -1, nv);
                    nodeMatrix[nv.x][nv.y] = nNode;
                }

                //Ignore closed set
                if (closed.contains(nNode))
                    continue;

                //Pathfinding!
                int tScore = n.sCost + nn.getMovementCost();
                if (!open.contains(nNode)) {
                    nNode.sCost = tScore;
                    nNode.eCost = nNode.sCost + distanceHeuristic(nv, end);
                    open.add(nNode);
                } else if (tScore >= nNode.sCost) {
                    continue;
                }
                nNode.cameFrom = n;
                nNode.sCost = tScore;
                nNode.eCost = nNode.sCost + distanceHeuristic(nv, end);
            }
        }
        return null;
    }

    private int distanceHeuristic(Vec2i a, Vec2i b) {
        //Convert a to cube
        int xa = a.y;
        int za = a.x - a.y - (a.y%2) / 2;
        int ya = -xa - za;

        //Convert b to cube
        int xb = b.y;
        int zb = b.x - b.y - (b.y%2) / 2;
        int yb = -xb - zb;

        return Math.max(Math.abs(xa-xb), Math.max(Math.abs(ya-yb), Math.abs(za-zb)));
    }

    private Direction findDirection(Vec2i from, Vec2i too) {
        Vec2i c = too.sub(from);
        if(c.x == 0)
            return (c.y > 0) ? Direction.South : Direction.North;
        if(c.x > 0)
            return (c.y == from.x%2) ? Direction.SouthEast : Direction.NorthEast;
        return (c.y == from.x%2) ? Direction.SouthWest : Direction.NorthWest;
    }
}


