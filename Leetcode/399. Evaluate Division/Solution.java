class Solution {
    class Pair{
        String node;
        double distance;
        Pair(String node, double distance){
            this.node = node;
            this.distance = distance;
        }
    
    }

    private void generateGraph(HashMap<String, ArrayList<Pair>> graph, List<List<String>> equations, double[] values){
        for(int i=0;i<equations.size();i++){
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double wt = values[i];
            graph.get(from).add(new Pair(to, wt));
            graph.get(to).add(new Pair(from, 1/wt));
        }
    }

    private double dfs(HashMap<String, ArrayList<Pair>> graph, String from, String to, HashSet<String> visited){
        if(from.equals(to)){
            return 1.0;
        }
        visited.add(from);
        for(Pair nbr: graph.get(from)){
            if(!visited.contains(nbr.node)){
                double ans = dfs(graph, nbr.node, to, visited);
                if(ans != -1.0){
                    return ans * nbr.distance;
                }
            }
        }
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<Pair>> graph = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        generateGraph(graph, equations, values);
        double[] ans = new double[queries.size()];

        for(int i=0; i<queries.length; i++){
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            if(!graph.containsKey(from) || !graph.containsKey(to)){
                ans[i] = -1.0;
                continue;
            }
            if(from.equals(to)){
                ans[i] = 1.0;
                continue;
            }
            ans[i] = dfs(graph, from, to, visited);
        }

        return ans;

        

    }

    public static void main(String[] args) {
                List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));
        double[] values = {2.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList("a", "b")));
        queries.add(new )
    }
}