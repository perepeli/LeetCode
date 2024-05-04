package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class DesignBrowserHistory {
    private Deque<String> backwardStack;
    private Deque<String> forwardStack;
    String currentUrl;

    public DesignBrowserHistory(String homepage) {
        backwardStack = new ArrayDeque<>();
        forwardStack = new ArrayDeque<>();
        currentUrl = homepage;
    }

    public void visit(String url) {
        if(!forwardStack.isEmpty()) forwardStack = new ArrayDeque<>();
        backwardStack.addLast(currentUrl);
        currentUrl = url;
    }

    public String back(int steps) {
        if(backwardStack.isEmpty()) return currentUrl;

        while(!backwardStack.isEmpty() && steps > 0) {
            forwardStack.addLast(currentUrl);
            currentUrl = backwardStack.removeLast();
            steps--;
        }

        return currentUrl;
    }

    public String forward(int steps) {
        if(forwardStack.isEmpty()) return currentUrl;

        while(!forwardStack.isEmpty() && steps > 0) {
            backwardStack.addLast(currentUrl);
            currentUrl = forwardStack.removeLast();
            steps--;
        }

        return currentUrl;
    }
}
