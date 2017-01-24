package algorithms.graph;

/**
 * Created by brito on 9/25/16.
 */
public class UF {

    private int[] id;
    private int[] sz;

    public UF(int n) {
        id = new int[n];
        for (int i = 0; i < n ; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public boolean connectec(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
//      Too slow -> N^2
//        int pid = id[p];
//        int qid = id[q];
//
//        for (int i = 0; i < id.length; i++) {
//            if (id[i] == qid) id[i] = qid;
//        }

        int pid = root(p);
        int qid = root(q);
        if (pid == qid) return;
        if (sz[pid] < sz[qid]) {id[pid] = qid; sz[qid] += sz[pid];}
        else {id[qid] = pid; id[pid] += id[qid];}
    }

    public int root(int i) {
        while(i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

}
