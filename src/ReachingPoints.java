
public class ReachingPoints {
    public static void Run() {
        System.out.println(reachingPoints(2, 3, 11, 3));
    }

    private static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // base case
        if (tx < sx || ty < sy) {
            return false;
        }
        if (tx == sx && ty == sy) {
            return true;
        }
        if ( (tx/sy - sx) * sx + sy == tx && sy == ty || 
             (ty/sx - sy) * sy + sx == ty && sx == tx) {
            return true;
        }


        if (tx < ty) {
            return reachingPoints(sx, sy, tx, ty - tx);
        }

        return reachingPoints(sx, sy, tx - ty, ty);
    }
}
