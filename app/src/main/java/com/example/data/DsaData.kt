package com.example.data

import com.example.model.Difficulty
import com.example.model.DsaProblem

object DsaData {
    val problems: List<DsaProblem> = listOf(
        // --- TRACK A: NORMAL DSA PRACTICE ---
        DsaProblem(
            id = "norm-1",
            title = "Two Sum",
            topic = "Arrays & Hashing",
            difficulty = Difficulty.BEGINNER,
            track = "Normal",
            practiceUrl = "https://leetcode.com/problems/two-sum/",
            platform = "LeetCode",
            timeComplexity = "O(N)",
            spaceComplexity = "O(N)",
            prerequisites = "Arrays, Hash Map constant-time lookup",
            hint = "Maintain a hash map of seen numbers to their indices. For each element, check if (target - num) has already been stored."
        ),
        DsaProblem(
            id = "norm-2",
            title = "Valid Palindrome",
            topic = "Two Pointers",
            difficulty = Difficulty.BEGINNER,
            track = "Normal",
            practiceUrl = "https://leetcode.com/problems/valid-palindrome/",
            platform = "LeetCode",
            timeComplexity = "O(N)",
            spaceComplexity = "O(1)",
            prerequisites = "Two pointers, String char manipulation",
            hint = "Place one pointer at index 0 and another at length - 1. Increment/decrement while skipping non-alphanumeric chars, comparing lowercase characters."
        ),
        DsaProblem(
            id = "norm-3",
            title = "Best Time to Buy and Sell Stock",
            topic = "Two Pointers & Sliding Window",
            difficulty = Difficulty.BEGINNER,
            track = "Normal",
            practiceUrl = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/",
            platform = "LeetCode",
            timeComplexity = "O(N)",
            spaceComplexity = "O(1)",
            prerequisites = "Single pass array traversal",
            hint = "Track the minimum price seen so far. At each day, calculate (current price - min price) and update max profit."
        ),
        DsaProblem(
            id = "norm-4",
            title = "Valid Parentheses",
            topic = "Stacks & Queues",
            difficulty = Difficulty.BEGINNER,
            track = "Normal",
            practiceUrl = "https://leetcode.com/problems/valid-parentheses/",
            platform = "LeetCode",
            timeComplexity = "O(N)",
            spaceComplexity = "O(N)",
            prerequisites = "Stack LIFO operations",
            hint = "Push open brackets onto stack. When finding a closing bracket, check whether the top of the stack has the corresponding opening bracket."
        ),
        DsaProblem(
            id = "norm-5",
            title = "Reverse a Linked List",
            topic = "Linked Lists",
            difficulty = Difficulty.BEGINNER,
            track = "Normal",
            practiceUrl = "https://leetcode.com/problems/reverse-linked-list/",
            platform = "LeetCode",
            timeComplexity = "O(N)",
            spaceComplexity = "O(1)",
            prerequisites = "Pointer / Reference manipulation",
            hint = "Maintain prev, curr, and next pointers. Invert curr.next to point to prev iteratively while stepping forward."
        ),
        DsaProblem(
            id = "norm-6",
            title = "Maximum Subarray (Kadane's Algorithm)",
            topic = "Arrays & Dynamic Programming",
            difficulty = Difficulty.INTERMEDIATE,
            track = "Normal",
            practiceUrl = "https://leetcode.com/problems/maximum-subarray/",
            platform = "LeetCode",
            timeComplexity = "O(N)",
            spaceComplexity = "O(1)",
            prerequisites = "Prefix sums or dynamic accumulation",
            hint = "Decide whether to add the current number to the existing running sum or restart a new subarray: currSum = max(num, currSum + num)."
        ),
        DsaProblem(
            id = "norm-7",
            title = "Invert / Mirror Binary Tree",
            topic = "Trees & BST",
            difficulty = Difficulty.BEGINNER,
            track = "Normal",
            practiceUrl = "https://leetcode.com/problems/invert-binary-tree/",
            platform = "LeetCode",
            timeComplexity = "O(N)",
            spaceComplexity = "O(H)",
            prerequisites = "Tree recursion",
            hint = "Swap node.left and node.right pointers, then recursively invoke invertTree on the children."
        ),
        DsaProblem(
            id = "norm-8",
            title = "Binary Search",
            topic = "Searching & Sorting",
            difficulty = Difficulty.BEGINNER,
            track = "Normal",
            practiceUrl = "https://leetcode.com/problems/binary-search/",
            platform = "LeetCode",
            timeComplexity = "O(log N)",
            spaceComplexity = "O(1)",
            prerequisites = "Sorted array indices",
            hint = "Compute mid = low + (high - low) / 2 to prevent overflow, and bisect the search bounds based on comparison with target."
        ),
        DsaProblem(
            id = "norm-9",
            title = "Binary Tree Level Order Traversal (BFS)",
            topic = "Trees & BST",
            difficulty = Difficulty.INTERMEDIATE,
            track = "Normal",
            practiceUrl = "https://leetcode.com/problems/binary-tree-level-order-traversal/",
            platform = "LeetCode",
            timeComplexity = "O(N)",
            spaceComplexity = "O(W)",
            prerequisites = "FIFO Queue operations",
            hint = "Use a queue. Inspect queue.size at the start of each level iteration to process all nodes of that depth together."
        ),
        DsaProblem(
            id = "norm-10",
            title = "Number of Islands",
            topic = "Graphs & BFS/DFS",
            difficulty = Difficulty.INTERMEDIATE,
            track = "Normal",
            practiceUrl = "https://leetcode.com/problems/number-of-islands/",
            platform = "LeetCode",
            timeComplexity = "O(M * N)",
            spaceComplexity = "O(M * N)",
            prerequisites = "2D Grid matrix traversal, DFS/BFS",
            hint = "Iterate through the grid. When encountering an unvisited '1', trigger DFS to mark all connected land cells as visited and increment island count."
        ),

        // --- TRACK B: FAANG-LEVEL DSA PRACTICE ---
        DsaProblem(
            id = "faang-1",
            title = "Trapping Rain Water",
            topic = "Two Pointers / Monotonic Stack",
            difficulty = Difficulty.ADVANCED,
            track = "FAANG",
            practiceUrl = "https://leetcode.com/problems/trapping-rain-water/",
            platform = "LeetCode",
            timeComplexity = "O(N)",
            spaceComplexity = "O(1)",
            prerequisites = "Two pointers elevation boundaries",
            hint = "Maintain leftMax and rightMax with two boundary pointers. The water trapped on the shorter side is bounded by that side's max height."
        ),
        DsaProblem(
            id = "faang-2",
            title = "Koko Eating Bananas",
            topic = "Binary Search on Answers",
            difficulty = Difficulty.INTERMEDIATE,
            track = "FAANG",
            practiceUrl = "https://leetcode.com/problems/koko-eating-bananas/",
            platform = "LeetCode",
            timeComplexity = "O(N * log(maxPile))",
            spaceComplexity = "O(1)",
            prerequisites = "Monotonic predicate check function",
            hint = "The search range for speed k is [1, max(piles)]. Implement a helper boolean canFinish(speed, h) and binary search for minimum viable k."
        ),
        DsaProblem(
            id = "faang-3",
            title = "LRU Cache Design",
            topic = "Design & Linked Structures",
            difficulty = Difficulty.INTERMEDIATE,
            track = "FAANG",
            practiceUrl = "https://leetcode.com/problems/lru-cache/",
            platform = "LeetCode",
            timeComplexity = "O(1) all methods",
            spaceComplexity = "O(Capacity)",
            prerequisites = "Doubly Linked List + Hash Map",
            hint = "Pair a Doubly Linked List (for constant-time node removals and head prepends) with a Hash Map mapping keys to node references."
        ),
        DsaProblem(
            id = "faang-4",
            title = "Course Schedule (Topological Sort)",
            topic = "Graphs & Cycle Detection",
            difficulty = Difficulty.INTERMEDIATE,
            track = "FAANG",
            practiceUrl = "https://leetcode.com/problems/course-schedule/",
            platform = "LeetCode",
            timeComplexity = "O(V + E)",
            spaceComplexity = "O(V + E)",
            prerequisites = "Kahn's in-degree algorithm or DFS coloring",
            hint = "Construct an adjacency list and calculate in-degrees. Use Kahn's BFS queue. If the count of nodes processed != total courses, a cycle exists."
        ),
        DsaProblem(
            id = "faang-5",
            title = "Longest Increasing Subsequence (LIS)",
            topic = "Dynamic Programming & Patience Sorting",
            difficulty = Difficulty.INTERMEDIATE,
            track = "FAANG",
            practiceUrl = "https://leetcode.com/problems/longest-increasing-subsequence/",
            platform = "LeetCode",
            timeComplexity = "O(N log N)",
            spaceComplexity = "O(N)",
            prerequisites = "Binary search on tail array",
            hint = "Maintain an array of active tails. For each incoming number, use binary search to replace the smallest tail >= current, or append if greater than all."
        ),
        DsaProblem(
            id = "faang-6",
            title = "Alien Dictionary",
            topic = "Topological Sort on Directed Graph",
            difficulty = Difficulty.ADVANCED,
            track = "FAANG",
            practiceUrl = "https://leetcode.com/problems/alien-dictionary/",
            platform = "LeetCode",
            timeComplexity = "O(Total Characters)",
            spaceComplexity = "O(1) alphabet size <= 26",
            prerequisites = "Graph building and DAG topological ordering",
            hint = "Compare consecutive words to find the first differing character to establish directed order edges. Run topological sort, watching for cycles."
        ),
        DsaProblem(
            id = "faang-7",
            title = "Median of Two Sorted Arrays",
            topic = "Binary Search on Partitions",
            difficulty = Difficulty.ADVANCED,
            track = "FAANG",
            practiceUrl = "https://leetcode.com/problems/median-of-two-sorted-arrays/",
            platform = "LeetCode",
            timeComplexity = "O(log(min(M, N)))",
            spaceComplexity = "O(1)",
            prerequisites = "Binary search on shorter array partition",
            hint = "Partition both arrays simultaneously such that the left half contains (M + N + 1) / 2 elements and maxLeftA <= minRightB and maxLeftB <= minRightA."
        )
    )
}
