
public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		int maxValue = maxValue(node);
		System.out.println(maxValue);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		if (node.isTerminal()) {
			return node.getValue();
		}
		int maxValue = Integer.MIN_VALUE;
		node.getChildren().sort(Node.LabelComparator);
		for (Node child : node.getChildren()) {
			int minValue = minValue(child);
			maxValue = Math.max(maxValue, minValue);
		}

		return maxValue;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		if (node.isTerminal()) {
			return node.getValue();
		}
		int minValue = Integer.MAX_VALUE;
		node.getChildren().sort(Node.LabelComparator);
		for (Node child : node.getChildren()) {
			int maxValue = maxValue(child);
			minValue = Math.min(minValue, maxValue);
		}
		return minValue;
	}
}
