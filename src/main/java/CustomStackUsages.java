import java.io.Console;

public class CustomStackUsages {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(5);
        stack.push(7);
        stack.push(9);
        stack.push(11);
        stack.push(18);
        stack.push(34);
        stack.push(-7);
        stack.push(0);
        stack.push(2);
        stack.push(4);

        int[] queue = stack.asQueue();
        int breakingPointIndex = Helpers.getBreakingPoint(queue);
        if (breakingPointIndex != -1) {
            System.out.println("Breaking point found at index " + breakingPointIndex +
                    ", value: " + queue[breakingPointIndex]);
        } else {
            System.out.println("No breaking point found.");
        }
    }
}
