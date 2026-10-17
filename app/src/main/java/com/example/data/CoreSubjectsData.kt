package com.example.data

import com.example.model.CoreCourse
import com.example.model.LanguageBadge

object CoreSubjectsData {
    val courses: List<CoreCourse> = listOf(
        CoreCourse(
            id = "c-lang",
            name = "C Programming",
            slug = "c-programming",
            designatedProvider = "CodeWithHarry",
            language = LanguageBadge.HINDI,
            playlistUrl = "https://www.youtube.com/playlist?list=PLu0W_9lII9aiXlHcLx-mDH1Qul38lC3QR",
            prerequisites = listOf("Basic computer operations", "Logical thinking mindset"),
            description = "The definitive foundation for every computer science engineer. Teaches memory layout, direct pointers, memory allocation, and procedural architecture.",
            orderedTopics = listOf(
                "Variables, Data Types, Format Specifiers",
                "Control Flow: If-Else, Switch, Loops",
                "Functions, Call by Value vs Call by Reference",
                "Pointers & Memory Addresses (Pointers Arithmetic)",
                "1D & 2D Arrays, String Manipulation (string.h)",
                "Structures, Unions and Typedef",
                "Dynamic Memory Allocation (malloc, calloc, realloc, free)",
                "File Handling (fopen, fread, fwrite, fclose)"
            ),
            miniProjects = listOf(
                "Student Management Terminal Record System",
                "Matrix Determinant and Multiplication Calculator",
                "CLI Snake and Ladder Game"
            ),
            checklist = listOf(
                "Explain pointer arithmetic and memory addressing clearly",
                "Allocate dynamic 2D array and prevent memory leaks using free()",
                "Read and write formatted data to local files safely"
            ),
            recommendedNext = "cpp-lang"
        ),
        CoreCourse(
            id = "cpp-lang",
            name = "C++ Programming",
            slug = "cpp-programming",
            designatedProvider = "Apna College",
            language = LanguageBadge.HINGLISH,
            playlistUrl = "https://www.youtube.com/playlist?list=PLfqMhTWNBTe0b2nM6JHVCnAkhQRGiZMSJ",
            prerequisites = listOf("Basic procedural programming concept"),
            description = "High-performance object-oriented programming, standard template library (STL), and modern C++ abstractions essential for DSA and system software.",
            orderedTopics = listOf(
                "Namespaces, I/O Streams, References",
                "OOP Core: Classes, Objects, Access Specifiers",
                "Constructors, Destructors, Copy Constructors",
                "Inheritance, Function Overriding, Virtual Functions",
                "Abstract Classes & Pure Virtual Functions",
                "Templates & Generic Functions/Classes",
                "STL Containers: Vector, List, Deque, Set, Map, Unordered Map",
                "STL Algorithms: Sort, Binary Search, Custom Comparators"
            ),
            miniProjects = listOf(
                "Bank Account System with Polymorphism",
                "Custom Dynamic Array Class with Operator Overloading",
                "Console Inventory Management System"
            ),
            checklist = listOf(
                "Demonstrate runtime polymorphism using base class pointers and virtual functions",
                "Use std::vector and std::unordered_map with optimal time complexity",
                "Avoid shallow copy memory corruption with copy constructors"
            ),
            recommendedNext = "dsa-course"
        ),
        CoreCourse(
            id = "python-lang",
            name = "Python Programming",
            slug = "python-programming",
            designatedProvider = "Apna College",
            language = LanguageBadge.HINGLISH,
            playlistUrl = "https://www.youtube.com/playlist?list=PLfqMhTWNBTe137I_EPQd34TsgV6IO55pt",
            prerequisites = listOf("None - Completely beginner friendly"),
            description = "Versatile high-productivity programming language used universally in Automation, Data Analysis, Artificial Intelligence, and Web Backend engineering.",
            orderedTopics = listOf(
                "Python Interpreter, Variables, Dynamic Typing",
                "Strings, Slicing, and Built-in String Methods",
                "Collections: Lists, Tuples, Sets, Dictionaries",
                "Loops and List/Dictionary Comprehensions",
                "Functions, *args, **kwargs, Lambda Expressions",
                "OOP in Python: Classes, Dunder Methods, Inheritance",
                "File I/O, Context Managers (with), Exception Handling",
                "Virtual Environments, pip, and Module Packaging"
            ),
            miniProjects = listOf(
                "Automated Web Scraper with BeautifulSoup",
                "Interactive CLI Todo App with JSON File Persistence",
                "Password Strength Analyzer & Generator"
            ),
            checklist = listOf(
                "Write clean list and dictionary comprehensions",
                "Build modular CLI scripts using try/except blocks",
                "Manage project dependencies using virtual environments"
            ),
            recommendedNext = "web-dev"
        ),
        CoreCourse(
            id = "web-dev",
            name = "Web Development",
            slug = "web-development",
            designatedProvider = "CodeWithHarry",
            language = LanguageBadge.HINDI,
            playlistUrl = "https://www.youtube.com/playlist?list=PLu0W_9lII9agq5TrH9XLIKQvv0iaF2X3w",
            prerequisites = listOf("Basic logical problem-solving"),
            description = "Complete full-stack roadmap starting from semantic HTML5, CSS Flexbox and Grid, vanilla JavaScript DOM to modern Node.js and Express servers.",
            orderedTopics = listOf(
                "Semantic HTML5 & Accessibility (a11y)",
                "CSS3 Layouts: Flexbox, CSS Grid, Responsive Media Queries",
                "JavaScript Core: Scope, Closures, DOM Manipulation",
                "Asynchronous JS: Event Loop, Promises, Async/Await",
                "Fetch API & RESTful JSON Data Consumption",
                "Node.js Runtime & Express HTTP Server Architecture",
                "REST API Endpoint Creation with Middleware",
                "MongoDB / PostgreSQL Database Integration"
            ),
            miniProjects = listOf(
                "Mobile-Responsive Developer Portfolio",
                "Real-time Weather Application consuming public APIs",
                "Fullstack Notes App with Authentication"
            ),
            checklist = listOf(
                "Build a 100% mobile responsive UI without heavy CSS libraries",
                "Fetch remote data asynchronously with proper loading/error states",
                "Deploy a working web application to a free hosting provider"
            ),
            recommendedNext = "dbms-course"
        ),
        CoreCourse(
            id = "java-lang",
            name = "Java Programming",
            slug = "java-programming",
            designatedProvider = "Kunal Kushwaha / Apna College",
            language = LanguageBadge.HINGLISH,
            playlistUrl = "https://www.youtube.com/results?search_query=Java+Complete+Course+Apna+College+Hindi",
            prerequisites = listOf("Basic computer logic"),
            description = "Platform-independent, enterprise-grade object-oriented language. Core for Android app development, backend microservices, and campus placement drives.",
            orderedTopics = listOf(
                "JVM, JRE, JDK Architecture & Bytecode",
                "OOP in Java: Encapsulation, Abstraction, Polymorphism",
                "Interfaces, Abstract Classes, and Packages",
                "Exception Handling (try-catch-finally, custom exceptions)",
                "Collections Framework (ArrayList, LinkedList, HashMap, HashSet)",
                "Multithreading & Concurrency (Thread, Runnable, Synchronization)",
                "Generics, Streams API, and Lambda Expressions",
                "File I/O and Serialization"
            ),
            miniProjects = listOf(
                "Employee Management Desktop GUI / CLI",
                "Multithreaded Web Downloader Simulation",
                "E-Commerce Cart Processing Engine"
            ),
            checklist = listOf(
                "Explain Java memory areas: Heap vs Stack vs Metaspace",
                "Use Java Collections Framework with correct Big-O tradeoffs",
                "Write thread-safe methods using synchronized blocks"
            ),
            recommendedNext = "dsa-course"
        ),
        CoreCourse(
            id = "dbms-course",
            name = "DBMS & SQL",
            slug = "dbms-sql",
            designatedProvider = "Gate Smashers",
            language = LanguageBadge.HINGLISH,
            playlistUrl = "https://www.youtube.com/results?search_query=Gate+Smashers+DBMS+Playlist",
            prerequisites = listOf("Basic programming", "Set theory basics"),
            description = "Relational database modeling, ER diagrams, SQL queries, normalization, ACID transaction properties, and B-Tree indexing.",
            orderedTopics = listOf(
                "Database Architecture: 3-Schema Architecture",
                "Entity-Relationship (ER) Modeling to Relational Mapping",
                "Relational Algebra & Relational Calculus",
                "SQL Mastery: DDL, DML, Complex Joins, Aggregates, Subqueries",
                "Functional Dependencies & Normalization (1NF, 2NF, 3NF, BCNF)",
                "Transaction Processing & ACID Properties",
                "Concurrency Control: 2-Phase Locking (2PL), Deadlocks",
                "Indexing: B-Tree and B+ Tree structures"
            ),
            miniProjects = listOf(
                "University Database Schema with Complex Subqueries & Views",
                "Normalized Hospital Management Schema (3NF)"
            ),
            checklist = listOf(
                "Write complex INNER, LEFT, and FULL OUTER joins with GROUP BY/HAVING",
                "Identify candidate keys and normalize tables to BCNF",
                "Explain Dirty Read and Unrepeatable Read anomalies"
            ),
            recommendedNext = "os-course"
        ),
        CoreCourse(
            id = "os-course",
            name = "Operating Systems",
            slug = "operating-systems",
            designatedProvider = "Gate Smashers",
            language = LanguageBadge.HINGLISH,
            playlistUrl = "https://www.youtube.com/results?search_query=Gate+Smashers+Operating+System+Playlist",
            prerequisites = listOf("C Programming", "Computer Architecture"),
            description = "How hardware integrates with software: processes, threads, concurrency, CPU scheduling, virtual memory, and file systems.",
            orderedTopics = listOf(
                "Process Lifecycle, Dual Mode, PCB & System Calls",
                "CPU Scheduling (Preemptive vs Non-Preemptive)",
                "Process Synchronization, Critical Section, Semaphores & Mutex",
                "Classical Synchronization Problems (Producer-Consumer)",
                "Deadlocks: Prevention, Avoidance (Banker's), Detection",
                "Memory Management: Paging, Segmentation, TLB",
                "Virtual Memory: Page Faults & Page Replacement Algorithms",
                "Disk Scheduling: SCAN, C-SCAN, SSTF"
            ),
            miniProjects = listOf(
                "Custom Linux Shell in C using fork() and execvp()",
                "Thread-safe Bounded Buffer Simulation with pthreads"
            ),
            checklist = listOf(
                "Explain step-by-step kernel context switching",
                "Trace Banker's safety algorithm on paper",
                "Calculate page faults for reference string using LRU"
            ),
            recommendedNext = "cn-course"
        ),
        CoreCourse(
            id = "cn-course",
            name = "Computer Networks",
            slug = "computer-networks",
            designatedProvider = "Gate Smashers",
            language = LanguageBadge.HINGLISH,
            playlistUrl = "https://www.youtube.com/results?search_query=Gate+Smashers+Computer+Networks+Playlist",
            prerequisites = listOf("Operating Systems basics"),
            description = "OSI and TCP/IP 5-layer models, IPv4 subnetting, routing algorithms, transport layer flow/congestion control, and application protocols.",
            orderedTopics = listOf(
                "OSI vs TCP/IP Network Architectures",
                "Physical & Data Link: Framing, CRC Error Detection, MAC",
                "Network Layer: IPv4 Addressing, CIDR Subnetting, NAT",
                "Routing Algorithms: Distance Vector & Link State (OSPF)",
                "Transport Layer: TCP 3-Way Handshake, Sliding Window Flow Control",
                "TCP Congestion Control (Slow Start, Congestion Avoidance)",
                "UDP Protocol & Sockets Programming",
                "Application Layer: DNS Resolution, HTTP/HTTPS, DHCP"
            ),
            miniProjects = listOf(
                "TCP Multi-Client Chat Server in Python",
                "IP Subnet Mask & Usable Hosts Calculator"
            ),
            checklist = listOf(
                "Calculate network ID, broadcast IP, and usable hosts for CIDR /27",
                "Diagram TCP 3-way handshake and 4-way disconnect flow",
                "Trace DNS iterative vs recursive query resolution"
            ),
            recommendedNext = "dsa-course"
        ),
        CoreCourse(
            id = "git-github",
            name = "Git & GitHub",
            slug = "git-github",
            designatedProvider = "Apna College / Kunal Kushwaha",
            language = LanguageBadge.HINGLISH,
            playlistUrl = "https://www.youtube.com/results?search_query=Git+and+Github+One+Shot+Apna+College+Hindi",
            prerequisites = listOf("Terminal basics"),
            description = "Version control essentials, branching strategies, conflict resolution, Pull Requests, and open source collaboration.",
            orderedTopics = listOf(
                "VCS Concepts, Git Architecture (Working Dir, Staging, Repo)",
                "Init, Add, Commit, Status, Log, Diff",
                "Branching, Checkout, Switch, Merging",
                "Merge Conflicts Resolution",
                "Remote Repositories: Push, Pull, Fetch, Upstream",
                "Rebasing vs Merging & Interactive Rebase",
                "GitHub Pull Requests, Issues, and Forking Workflows"
            ),
            miniProjects = listOf(
                "Contribute a documentation or bug fix to a public open-source project",
                "Host a live portfolio on GitHub Pages"
            ),
            checklist = listOf(
                "Resolve a git merge conflict cleanly using VS Code",
                "Submit a clean pull request with informative commit messages"
            ),
            recommendedNext = "web-dev"
        )
    )
}
