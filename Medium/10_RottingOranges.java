class Solution {
    public static class pair {
        int i;
        int j;
        int level;

        pair(int i, int j, int l) {
            this.i = i;
            this.j = j;
            this.level = l;
        }
    }
    public static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    public int orangesRotting(int[][] rooms) {
        LinkedList<pair> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 2) {
                    queue.addLast(new pair(i, j, 0));
                }
            }
        }
        int ans=0;
        while (queue.size() != 0) {
            pair vertex = queue.removeFirst();
            for (int d = 0; d < dir.length; d++) {
                int r = vertex.i + dir[d][0];
                int c = vertex.j + dir[d][1];
                if (r >= 0 && c >= 0 && r < rooms.length && c < rooms[0].length && rooms[r][c] == 1) {
                    queue.addLast(new pair(r, c, vertex.level + 1));
                    rooms[r][c] = 2;
                }
            }
            if(ans<vertex.level) ans=vertex.level;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;

    }
}

