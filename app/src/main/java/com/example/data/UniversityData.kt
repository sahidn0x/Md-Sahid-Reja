package com.example.data

import com.example.model.LanguageBadge
import com.example.model.UnitTopic
import com.example.model.UniversitySubject

object UniversityData {
    val subjects: List<UniversitySubject> = listOf(
        UniversitySubject(
            code = "KCS-301",
            name = "Data Structures",
            semester = 3,
            branch = "Both",
            academicYear = "2023-24 & 2024-25",
            lastVerifiedDate = "October 2024",
            officialSyllabusUrl = "https://aktu.ac.in/syllabus.html",
            summary = "Foundational study of linear and non-linear memory structures, asymptotic complexity, trees, graphs, and hashing techniques under AKTU guidelines.",
            units = listOf(
                UnitTopic(
                    unitNumber = 1,
                    unitTitle = "Introduction & Arrays",
                    topics = listOf(
                        "Asymptotic notations (Big O, Omega, Theta)",
                        "1D and 2D Array address calculation",
                        "Row-major & Column-major order",
                        "Sparse Matrix representations"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=Data+Structures+Unit+1+AKTU+Gate+Smasher",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/data-structures/"
                ),
                UnitTopic(
                    unitNumber = 2,
                    unitTitle = "Stacks & Queues",
                    topics = listOf(
                        "Stack implementations using Array & Linked List",
                        "Infix to Postfix/Prefix conversion algorithms",
                        "Evaluation of expressions",
                        "Circular Queue & Double-Ended Queue (Deque)"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=Stack+and+Queue+AKTU+Data+Structures+Hindi",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/stack-data-structure/"
                ),
                UnitTopic(
                    unitNumber = 3,
                    unitTitle = "Linked Lists",
                    topics = listOf(
                        "Singly Linked List insertions & deletions",
                        "Doubly Linked List operations",
                        "Circular Linked List",
                        "Polynomial representation & addition using lists"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=Linked+List+Complete+One+Shot+Hinglish",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/data-structures/linked-list/"
                ),
                UnitTopic(
                    unitNumber = 4,
                    unitTitle = "Trees & AVL Trees",
                    topics = listOf(
                        "Binary Tree traversals (Inorder, Preorder, Postorder)",
                        "Binary Search Tree (BST) operations",
                        "AVL Trees & LL, RR, LR, RL Rotations",
                        "Threaded Binary Trees overview"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=Binary+Trees+AVL+Trees+Gate+Smashers",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/binary-tree-data-structure/"
                ),
                UnitTopic(
                    unitNumber = 5,
                    unitTitle = "Graphs, Searching & Sorting",
                    topics = listOf(
                        "Graph traversals: Breadth-First & Depth-First Search",
                        "Minimum Spanning Trees: Prim's & Kruskal's",
                        "Dijkstra's shortest path algorithm",
                        "Quick Sort, Merge Sort, Heap Sort comparison",
                        "Hashing & Collision resolution techniques"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=Graph+Algorithms+BFS+DFS+AKTU+Hindi",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/"
                )
            ),
            examChecklist = listOf(
                "Derive Row-major and Column-major 2D array memory address formula.",
                "Practice manual conversions of infix expressions to postfix using stack trace tables.",
                "Draw AVL tree balance factors and execute rotation step-by-step.",
                "Trace BFS and DFS on a given 6-vertex directed graph.",
                "Compare Best, Average, and Worst case complexities of Merge Sort vs Quick Sort."
            )
        ),
        UniversitySubject(
            code = "KCS-401",
            name = "Operating Systems",
            semester = 4,
            branch = "Both",
            academicYear = "2023-24 & 2024-25",
            lastVerifiedDate = "September 2024",
            officialSyllabusUrl = "https://aktu.ac.in/syllabus.html",
            summary = "Core architecture of process scheduling, synchronization primitives, deadlocks, virtual memory paging, and disk scheduling algorithms.",
            units = listOf(
                UnitTopic(
                    unitNumber = 1,
                    unitTitle = "OS Overview & System Calls",
                    topics = listOf(
                        "Monolithic vs Microkernel architectures",
                        "Dual-mode operations (User mode vs Kernel mode)",
                        "System call execution lifecycle",
                        "Process Control Block (PCB) & Context switching"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=Operating+Systems+Gate+Smashers+Playlist",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/operating-systems/"
                ),
                UnitTopic(
                    unitNumber = 2,
                    unitTitle = "CPU Scheduling & Concurrency",
                    topics = listOf(
                        "FCFS, SJF, Round Robin, Priority Scheduling",
                        "Critical Section problem requirements",
                        "Peterson's solution and Counting/Binary Semaphores",
                        "Producer-Consumer & Dining Philosophers problems"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=CPU+Scheduling+and+Semaphores+Hindi",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/cpu-scheduling-in-operating-systems/"
                ),
                UnitTopic(
                    unitNumber = 3,
                    unitTitle = "Deadlock Handling",
                    topics = listOf(
                        "Four Coffman conditions for deadlock",
                        "Resource Allocation Graph (RAG)",
                        "Banker's Algorithm for deadlock avoidance",
                        "Deadlock Detection and Recovery mechanisms"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=Bankers+Algorithm+AKTU+Hindi",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/deadlock-in-operating-system/"
                ),
                UnitTopic(
                    unitNumber = 4,
                    unitTitle = "Memory Management & Paging",
                    topics = listOf(
                        "Logical vs Physical address translation",
                        "Paging, Segmentation and TLB lookups",
                        "Virtual memory & Page fault handling",
                        "Page replacement: FIFO, LRU, Optimal algorithms"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=Paging+and+LRU+Replacement+Gate+Smashers",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/virtual-memory-in-operating-system/"
                ),
                UnitTopic(
                    unitNumber = 5,
                    unitTitle = "File Systems & Disk Scheduling",
                    topics = listOf(
                        "File allocation methods (Contiguous, Linked, Indexed)",
                        "Disk scheduling: FCFS, SSTF, SCAN, C-SCAN, LOOK",
                        "Directory organizations and access control lists"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=Disk+scheduling+SCAN+CSCAN+Hindi",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/disk-scheduling-algorithms/"
                )
            ),
            examChecklist = listOf(
                "Solve Gantt chart numericals for Round Robin with varying arrival times.",
                "Execute Banker's algorithm step-by-step with 3 resource types.",
                "Calculate total page faults for LRU vs Optimal page replacement given an 18-element reference string.",
                "Compute total head movement for SCAN and C-SCAN disk arm algorithms."
            )
        ),
        UniversitySubject(
            code = "KCS-055",
            name = "Machine Learning",
            semester = 5,
            branch = "CSE (AI/ML)",
            academicYear = "2023-24 & 2024-25",
            lastVerifiedDate = "November 2024",
            officialSyllabusUrl = "https://aktu.ac.in/syllabus.html",
            summary = "Supervised algorithms, decision trees, neural network backpropagation, Naive Bayes, Support Vector Machines, and unsupervised clustering for AI/ML specializations.",
            units = listOf(
                UnitTopic(
                    unitNumber = 1,
                    unitTitle = "Introduction & Learning Theory",
                    topics = listOf(
                        "Supervised vs Unsupervised vs Reinforcement learning",
                        "Hypothesis space, Inductive bias and Version Spaces",
                        "Overfitting vs Underfitting and Regularization",
                        "Bias-Variance tradeoff"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=Machine+Learning+AKTU+Unit+1+Hindi",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://scikit-learn.org/stable/getting_started.html"
                ),
                UnitTopic(
                    unitNumber = 2,
                    unitTitle = "Decision Trees & Evaluation",
                    topics = listOf(
                        "Entropy and Information Gain calculation",
                        "ID3 & CART algorithms",
                        "Decision tree pruning techniques",
                        "Confusion Matrix, Precision, Recall, F1-score, ROC-AUC"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=Decision+Tree+ID3+AKTU+Machine+Learning",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/decision-tree/"
                ),
                UnitTopic(
                    unitNumber = 3,
                    unitTitle = "Linear Models & Neural Networks",
                    topics = listOf(
                        "Linear regression & Cost function minimization",
                        "Gradient Descent & Learning rate effects",
                        "Logistic regression & Sigmoid function",
                        "Perceptrons & Multi-Layer Perceptron backpropagation"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=Gradient+Descent+Backpropagation+Hindi+ML",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/backpropagation-in-neural-network/"
                ),
                UnitTopic(
                    unitNumber = 4,
                    unitTitle = "Bayesian Learning & SVM",
                    topics = listOf(
                        "Bayes Theorem & Maximum A Posteriori (MAP)",
                        "Naïve Bayes classifier for text classification",
                        "Support Vector Machines & Maximum Margin Hyperplanes",
                        "Kernel Trick (Linear, RBF, Polynomial)"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=Naive+Bayes+SVM+AKTU+Machine+Learning",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/support-vector-machine-algorithm/"
                ),
                UnitTopic(
                    unitNumber = 5,
                    unitTitle = "Clustering & Dimensionality Reduction",
                    topics = listOf(
                        "K-Means Clustering & Elbow method",
                        "Hierarchical agglomerative clustering",
                        "Principal Component Analysis (PCA) mathematics",
                        "Singular Value Decomposition (SVD) overview"
                    ),
                    recommendedLectureUrl = "https://www.youtube.com/results?search_query=K+Means+Clustering+PCA+Hindi+Machine+learning",
                    lectureLanguage = LanguageBadge.HINGLISH,
                    notesUrl = "https://www.geeksforgeeks.org/k-means-clustering-introduction/"
                )
            ),
            examChecklist = listOf(
                "Manually compute Information Gain from a 14-row weather dataset to pick the root node.",
                "Calculate Naive Bayes posterior probabilities by hand for binary classification.",
                "Derive Gradient Descent weight update equations for single-variable linear regression.",
                "Step through 2 iterations of K-Means clustering given 2D points."
            )
        )
    )
}
