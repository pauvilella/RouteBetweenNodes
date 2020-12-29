public class Main {
    public static boolean existRoute(MyGraph<Integer> graph, MyGraphNode<Integer> s, MyGraphNode<Integer> e) {
        if (s == e) {
            return true;
        }
        MyGraphNode<Integer> root = s;
        MyQueue<MyGraphNode<Integer>> q = new MyQueue<MyGraphNode<Integer>>();
        for (MyGraphNode<Integer> n : graph.nodes) {
            n.marked = false;
            n.visited = false;
        }
        root.marked = true;
        q.add(root);
        while (!q.isEmpty()) {
            MyGraphNode<Integer> node = q.remove();
            if (node == e) {
                return true;
            }
            for (MyGraphNode<Integer> n : node.adjacents) {
                if (!n.marked) {
                    n.marked = true;
                    q.add(n);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        MyGraph<Integer> graph = MyGraph.generateGraph1();
        boolean result = existRoute(graph, graph.nodes.get(4), graph.nodes.get(5));
        System.out.println(result);
        result = existRoute(graph, graph.nodes.get(0), graph.nodes.get(3));
        System.out.println(result);
    }
}
