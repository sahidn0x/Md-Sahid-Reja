package com.example.data

import com.example.model.CurriculumModule
import com.example.model.Difficulty
import com.example.model.LanguageBadge
import com.example.model.RoadmapPhase
import com.example.model.Specialization
import com.example.model.SpecializationProject
import com.example.model.SpecializationResource

object SpecializationsData {
    val list: List<Specialization> = listOf(
        Specialization(
            id = "ai-ml",
            title = "AI & Machine Learning",
            slug = "ai-machine-learning",
            iconKey = "brain",
            tagline = "Teach computers to learn from patterns, automate complex decisions, and build intelligent applications.",
            prerequisites = listOf("Python Programming", "Linear Algebra & Calculus", "Probability & Statistics"),
            roadmap = listOf(
                RoadmapPhase("Phase 1", "Data Foundations", "Python data wrangling with NumPy, Pandas, Matplotlib, and Exploratory Data Analysis.", listOf("Python", "NumPy", "Pandas")),
                RoadmapPhase("Phase 2", "Classical Machine Learning", "Regression, Decision Trees, Random Forests, SVM, and Scikit-Learn pipelines.", listOf("Scikit-Learn", "Feature Eng")),
                RoadmapPhase("Phase 3", "Deep Learning & Neural Networks", "PyTorch fundamentals, CNNs for computer vision, RNNs & Transformers for NLP.", listOf("PyTorch", "HuggingFace")),
                RoadmapPhase("Phase 4", "MLOps & Deployment", "FastAPI model serving, Docker containerization, ONNX, and model monitoring.", listOf("FastAPI", "Docker", "MLflow"))
            ),
            curriculum = listOf(
                CurriculumModule("Module 1: Mathematics for AI", listOf("Matrix operations & Eigenvalues", "Partial Derivatives & Chain Rule", "Bayesian Probability")),
                CurriculumModule("Module 2: Supervised & Unsupervised Learning", listOf("Linear & Logistic Regression", "Support Vector Machines", "K-Means Clustering & PCA")),
                CurriculumModule("Module 3: Modern Generative AI", listOf("Transformers architecture & Attention", "Retrieval Augmented Generation (RAG)", "Vector Databases (Chroma, Pinecone)"))
            ),
            resources = listOf(
                SpecializationResource(
                    id = "res-aiml-1",
                    title = "Machine Learning Specialization by Andrew Ng",
                    provider = "DeepLearning.AI / Coursera",
                    accessCost = "Free Audit Available",
                    language = LanguageBadge.ENGLISH,
                    url = "https://www.coursera.org/specializations/machine-learning-introduction",
                    difficulty = Difficulty.BEGINNER,
                    description = "World standard foundational ML concepts with intuitive mathematics and hands-on Python labs."
                ),
                SpecializationResource(
                    id = "res-aiml-2",
                    title = "Fast.ai: Practical Deep Learning for Coders",
                    provider = "Fast.ai",
                    accessCost = "100% Free",
                    language = LanguageBadge.ENGLISH,
                    url = "https://course.fast.ai/",
                    difficulty = Difficulty.INTERMEDIATE,
                    description = "Top-down practical deep learning instruction getting students building PyTorch models from day one."
                )
            ),
            projects = listOf(
                SpecializationProject(
                    name = "House Price Predictor API",
                    difficulty = Difficulty.BEGINNER,
                    description = "End-to-end regression model with data preprocessing, XGBoost training, and FastAPI REST endpoint.",
                    tech = listOf("Python", "Pandas", "XGBoost", "FastAPI")
                ),
                SpecializationProject(
                    name = "Domain Specific Document Q&A (RAG)",
                    difficulty = Difficulty.INTERMEDIATE,
                    description = "Chat with PDF documents using embeddings, LangChain, local vector store, and open LLMs.",
                    tech = listOf("LangChain", "ChromaDB", "HuggingFace", "Streamlit")
                )
            ),
            portfolioAdvice = listOf(
                "Host live demos on Streamlit Community Cloud or Hugging Face Spaces so recruiters can test them directly.",
                "Highlight baseline metrics vs tuned accuracy with confusion matrices in your GitHub README."
            ),
            careerGuidance = "Target roles in India: Junior ML Engineer, Data Scientist, AI Research Assistant. Pair strong Python with SQL and Docker to stand out."
        ),
        Specialization(
            id = "cybersecurity",
            title = "Cybersecurity & Ethical Hacking",
            slug = "cybersecurity",
            iconKey = "shield",
            tagline = "Defend digital infrastructure, discover system vulnerabilities, and master network defense.",
            prerequisites = listOf("Networking Fundamentals (TCP/IP)", "Linux Command Line", "Basic Python/Bash"),
            roadmap = listOf(
                RoadmapPhase("Phase 1", "Systems & Networks", "Linux administration, OSI models, Wireshark packet capture, and network scanning.", listOf("Linux", "Wireshark", "Bash")),
                RoadmapPhase("Phase 2", "Security Primitives", "Cryptography, Public Key Infrastructure, Firewalls, and OWASP Top 10 vulnerabilities.", listOf("Burp Suite", "Nmap", "OWASP")),
                RoadmapPhase("Phase 3", "Offensive & Defensive Labs", "Hands-on CTFs, privilege escalation, SOC operations, SIEM log analysis.", listOf("Metasploit", "Splunk", "TryHackMe")),
                RoadmapPhase("Phase 4", "Cloud Security & Auditing", "AWS IAM policies, reverse engineering basics, and secure code review standards.", listOf("Ghidra", "CloudTrail", "Snort"))
            ),
            curriculum = listOf(
                CurriculumModule("Module 1: Network & OS Security", listOf("Port scanning & service enumeration", "ARP spoofing & MITM", "Linux permissions & SUID escalation")),
                CurriculumModule("Module 2: Web App Security", listOf("SQL Injection (SQLi)", "Cross-Site Scripting (XSS)", "CSRF & Broken Authentication")),
                CurriculumModule("Module 3: Blue Team Operations", listOf("Splunk log investigation", "Snort Intrusion Detection", "Incident Response playbooks"))
            ),
            resources = listOf(
                SpecializationResource(
                    id = "res-cyber-1",
                    title = "TryHackMe: Pre-Security & Complete Beginner",
                    provider = "TryHackMe",
                    accessCost = "Free Rooms Available",
                    language = LanguageBadge.ENGLISH,
                    url = "https://tryhackme.com/",
                    difficulty = Difficulty.BEGINNER,
                    description = "Browser-based interactive rooms teaching networking, web application security, and Linux."
                )
            ),
            projects = listOf(
                SpecializationProject(
                    name = "Multi-Threaded Port Scanner in Python",
                    difficulty = Difficulty.BEGINNER,
                    description = "Script scanning target IP ranges for open ports and banners using socket library.",
                    tech = listOf("Python", "Sockets", "Threading")
                ),
                SpecializationProject(
                    name = "Isolated SOC Home Lab with Splunk",
                    difficulty = Difficulty.INTERMEDIATE,
                    description = "Set up an isolated virtual network to simulate attacks and analyze alerts in Splunk.",
                    tech = listOf("VirtualBox", "Splunk", "Kali Linux")
                )
            ),
            portfolioAdvice = listOf(
                "Document writeups of solved Capture-The-Flag (CTF) challenges on a personal tech blog or GitHub repo.",
                "Display your public TryHackMe or HackTheBox badge and rank on your resume."
            ),
            careerGuidance = "Entry roles: SOC Analyst (Tier 1), Junior Penetration Tester, Cybersecurity Consultant. Strong demand across Indian IT and banking."
        ),
        Specialization(
            id = "cloud-devops",
            title = "Cloud Computing & DevOps",
            slug = "cloud-devops",
            iconKey = "cloud",
            tagline = "Automate continuous deployment pipelines, manage container fleets, and scale infrastructure.",
            prerequisites = listOf("Linux OS Essentials", "Git & GitHub", "Basic Web Architecture"),
            roadmap = listOf(
                RoadmapPhase("Phase 1", "Linux & Scripting", "Advanced Bash scripting, SSH keys, cron jobs, and package management.", listOf("Linux", "Bash", "Git")),
                RoadmapPhase("Phase 2", "Containerization", "Dockerizing web applications, multi-stage builds, and Docker Compose.", listOf("Docker", "Containers")),
                RoadmapPhase("Phase 3", "Cloud Platforms & IaC", "AWS EC2, S3, RDS, IAM, VPC, and Infrastructure as Code with Terraform.", listOf("AWS", "Terraform")),
                RoadmapPhase("Phase 4", "CI/CD & Kubernetes", "GitHub Actions CI/CD pipelines, Kubernetes pod orchestration, and Prometheus monitoring.", listOf("Kubernetes", "GitHub Actions", "Prometheus"))
            ),
            curriculum = listOf(
                CurriculumModule("Module 1: Containers & Docker", listOf("Images vs Containers", "Dockerfile optimization", "Volumes and bridge networking")),
                CurriculumModule("Module 2: Cloud Infrastructure", listOf("Virtual Private Clouds (VPC)", "Security Groups & Subnets", "IAM least privilege policies")),
                CurriculumModule("Module 3: Continuous Delivery", listOf("Automated test pipelines", "Automated container builds", "Zero-downtime rolling updates"))
            ),
            resources = listOf(
                SpecializationResource(
                    id = "res-cloud-1",
                    title = "DevOps Bootcamp by TechWorld with Nana",
                    provider = "TechWorld with Nana",
                    accessCost = "100% Free",
                    language = LanguageBadge.ENGLISH,
                    url = "https://www.youtube.com/results?search_query=TechWorld+with+Nana+Docker+Kubernetes+Full+Course",
                    difficulty = Difficulty.BEGINNER,
                    description = "Clear, modern visual courses explaining Docker, Kubernetes, CI/CD, and cloud architectures."
                )
            ),
            projects = listOf(
                SpecializationProject(
                    name = "Zero-Downtime GitHub Actions CI/CD Pipeline",
                    difficulty = Difficulty.INTERMEDIATE,
                    description = "Pipeline running unit tests, building Docker containers, and deploying to cloud VPS on git push.",
                    tech = listOf("GitHub Actions", "Docker", "AWS EC2", "Nginx")
                )
            ),
            portfolioAdvice = listOf(
                "Include clean system architecture diagrams in your GitHub README created with diagrams.net.",
                "Provide a 1-click deploy badge or video walkthrough of your pipeline in action."
            ),
            careerGuidance = "Massive hiring momentum in Bengaluru, Hyderabad, and Pune for DevOps and Cloud Engineers. Practical hands-on pipeline skills trump theoretical knowledge."
        ),
        Specialization(
            id = "web-software",
            title = "Web & Software Development",
            slug = "web-software-development",
            iconKey = "globe",
            tagline = "Build scalable web platforms, high-throughput REST/GraphQL APIs, and microservices.",
            prerequisites = listOf("HTML, CSS & JavaScript", "Basic SQL"),
            roadmap = listOf(
                RoadmapPhase("Phase 1", "Modern Frontend", "React, TypeScript, responsive Tailwind CSS, state management.", listOf("React", "TypeScript", "Tailwind")),
                RoadmapPhase("Phase 2", "Backend Microservices", "Node.js/Express or FastAPI, PostgreSQL, Prisma ORM, JWT authentication.", listOf("Node.js", "PostgreSQL", "Prisma")),
                RoadmapPhase("Phase 3", "Fullstack Systems", "Next.js SSR/SSG, Redis caching, and cloud asset storage.", listOf("Next.js", "Redis", "S3")),
                RoadmapPhase("Phase 4", "System Architecture", "Message queues (RabbitMQ/Kafka), rate limiters, and automated testing.", listOf("System Design", "Docker", "Jest"))
            ),
            curriculum = listOf(
                CurriculumModule("Module 1: Advanced Frontend", listOf("Custom React Hooks", "TypeScript Generics & Types", "Performance profiling")),
                CurriculumModule("Module 2: Enterprise Backend", listOf("Database Indexing & Relations", "JWT & OAuth2 Authentication", "API Rate Limiting")),
                CurriculumModule("Module 3: Real-Time Systems", listOf("WebSockets bidirectional streaming", "Redis Pub/Sub", "Background Job Queues"))
            ),
            resources = listOf(
                SpecializationResource(
                    id = "res-web-1",
                    title = "Full Stack Open",
                    provider = "University of Helsinki",
                    accessCost = "100% Free",
                    language = LanguageBadge.ENGLISH,
                    url = "https://fullstackopen.com/en/",
                    difficulty = Difficulty.INTERMEDIATE,
                    description = "World standard open course on React, Redux, Node.js, Express, MongoDB, GraphQL, and TypeScript."
                )
            ),
            projects = listOf(
                SpecializationProject(
                    name = "Collaborative Kanban Board with WebSockets",
                    difficulty = Difficulty.INTERMEDIATE,
                    description = "Real-time task board with drag-and-drop, live collaborative cursors, and workspace permissions.",
                    tech = listOf("Next.js", "TypeScript", "PostgreSQL", "Socket.io", "Tailwind")
                )
            ),
            portfolioAdvice = listOf(
                "Deploy your projects live on Vercel or Render with test login credentials listed in the README.",
                "Maintain clean git commits and a green GitHub contribution graph."
            ),
            careerGuidance = "Highest volume of fresher hiring in India. Building real fullstack projects with authentication and SQL databases gives you the biggest placement edge."
        ),
        Specialization(
            id = "data-science",
            title = "Data Science & Data Engineering",
            slug = "data-science-engineering",
            iconKey = "database",
            tagline = "Transform raw data into strategic insights, ETL pipelines, and scalable analytical warehouses.",
            prerequisites = listOf("Python Basics", "SQL Queries", "Statistics"),
            roadmap = listOf(
                RoadmapPhase("Phase 1", "Analytics & SQL", "Advanced SQL, Window functions, Pandas wrangling, PowerBI/Tableau.", listOf("SQL", "Pandas", "PowerBI")),
                RoadmapPhase("Phase 2", "Applied Statistics", "Hypothesis testing, A/B testing methodologies, regression analysis.", listOf("SciPy", "Statsmodels")),
                RoadmapPhase("Phase 3", "Data Engineering Pipelines", "ETL workflows, Apache Airflow, distributed processing with Apache Spark.", listOf("Airflow", "PySpark", "PostgreSQL")),
                RoadmapPhase("Phase 4", "Modern Data Stack", "Data warehousing with Snowflake/BigQuery, dbt transformations.", listOf("dbt", "BigQuery"))
            ),
            curriculum = listOf(
                CurriculumModule("Module 1: Advanced SQL", listOf("Window functions (ROW_NUMBER, RANK)", "Common Table Expressions (CTEs)", "Query execution plans")),
                CurriculumModule("Module 2: Exploratory Data Analysis", listOf("Outlier detection", "Missing data imputation", "Correlation matrices")),
                CurriculumModule("Module 3: Data Warehousing", listOf("Star & Snowflake schemas", "Batch vs Streaming", "Scheduled Airflow DAGs"))
            ),
            resources = listOf(
                SpecializationResource(
                    id = "res-ds-1",
                    title = "Data Engineering Zoomcamp",
                    provider = "DataTalks.Club",
                    accessCost = "100% Free",
                    language = LanguageBadge.ENGLISH,
                    url = "https://github.com/DataTalksClub/data-engineering-zoomcamp",
                    difficulty = Difficulty.INTERMEDIATE,
                    description = "Hands-on open course covering Docker, Terraform, GCP, Airflow, Spark, Kafka, and dbt."
                )
            ),
            projects = listOf(
                SpecializationProject(
                    name = "E-Commerce Analytical Pipeline & Dashboard",
                    difficulty = Difficulty.INTERMEDIATE,
                    description = "ETL pipeline orchestrating daily CSV imports into PostgreSQL and generating Streamlit KPI reports.",
                    tech = listOf("Python", "PostgreSQL", "Airflow", "Streamlit")
                )
            ),
            portfolioAdvice = listOf(
                "Emphasize business impact in project descriptions (e.g. 'Reduced analytical query runtime by 42% via partitioning').",
                "Publish polished Jupyter Notebooks with clean Markdown explanations."
            ),
            careerGuidance = "High hiring for Data Analysts and Data Engineers in Indian fintech and e-commerce companies."
        ),
        Specialization(
            id = "app-dev",
            title = "App Development (Mobile)",
            slug = "app-development",
            iconKey = "smartphone",
            tagline = "Create native and cross-platform mobile apps for Android and iOS devices.",
            prerequisites = listOf("Object-Oriented Programming", "Kotlin or Dart basics"),
            roadmap = listOf(
                RoadmapPhase("Phase 1", "Language & Framework", "Dart/Flutter or Kotlin/Jetpack Compose fundamentals.", listOf("Flutter", "Jetpack Compose")),
                RoadmapPhase("Phase 2", "UI & State Management", "Screen navigation, animations, ViewModel, reactive state flows.", listOf("State Management", "Material 3")),
                RoadmapPhase("Phase 3", "Device Hardware & Storage", "Camera, GPS, SQLite/Room local database, Firebase push notifications.", listOf("Room", "SQLite", "Firebase")),
                RoadmapPhase("Phase 4", "Architecture & Deployment", "Clean Architecture, offline-first sync, and Google Play release.", listOf("Clean Arch", "Play Console"))
            ),
            curriculum = listOf(
                CurriculumModule("Module 1: Modern Mobile UI", listOf("Declarative UI trees", "Responsive screens", "Gesture handling")),
                CurriculumModule("Module 2: Local Persistence & APIs", listOf("Room / SQLite database", "Retrofit network calls", "Offline-first sync")),
                CurriculumModule("Module 3: Device Features", listOf("Location & Sensors", "Background workers", "Push notifications"))
            ),
            resources = listOf(
                SpecializationResource(
                    id = "res-app-1",
                    title = "Android Kotlin Fundamentals / Flutter Codelabs",
                    provider = "Google Developers",
                    accessCost = "100% Free",
                    language = LanguageBadge.ENGLISH,
                    url = "https://developer.android.com/courses",
                    difficulty = Difficulty.BEGINNER,
                    description = "Official Google interactive pathways teaching Kotlin, Jetpack Compose, and modern Android architecture."
                )
            ),
            projects = listOf(
                SpecializationProject(
                    name = "Offline-First Expense Tracker App",
                    difficulty = Difficulty.BEGINNER,
                    description = "Mobile application with local database persistence, monthly spend analytics, and PDF export.",
                    tech = listOf("Kotlin", "Jetpack Compose", "Room", "Charts")
                )
            ),
            portfolioAdvice = listOf(
                "Provide direct downloadable APK links in your GitHub releases so recruiters can test on their phones immediately.",
                "Record fluid 15-second screen recording GIFs showing smooth gestures and transitions."
            ),
            careerGuidance = "Strong startup and product company demand in India for developers proficient in modern declarative UI (Compose / Flutter)."
        ),
        Specialization(
            id = "blockchain",
            title = "Blockchain & Web3",
            slug = "blockchain-web3",
            iconKey = "blocks",
            tagline = "Decentralized consensus systems, smart contracts, and cryptographic protocols.",
            prerequisites = listOf("JavaScript/Python", "Basic Cryptography (Hashing, Public Keys)"),
            roadmap = listOf(
                RoadmapPhase("Phase 1", "Cryptography Core", "Hash functions, Merkle trees, public key crypto, PoW & PoS consensus.", listOf("Cryptography", "Consensus")),
                RoadmapPhase("Phase 2", "Smart Contract Development", "Solidity programming, EVM internals, OpenZeppelin standards.", listOf("Solidity", "Hardhat", "Remix")),
                RoadmapPhase("Phase 3", "Decentralized Apps (dApps)", "Ethers.js / Viem, connecting web frontends to MetaMask testnets.", listOf("Ethers.js", "Next.js", "Web3.js")),
                RoadmapPhase("Phase 4", "DeFi & Auditing", "ERC-20/721 tokens, reentrancy guards, security testing with Foundry.", listOf("Foundry", "Slither", "Auditing"))
            ),
            curriculum = listOf(
                CurriculumModule("Module 1: Blockchain Internals", listOf("Byzantine Fault Tolerance", "Ethereum Virtual Machine (EVM)", "Gas optimization")),
                CurriculumModule("Module 2: Solidity Mastery", listOf("Mappings, Structs, Events", "Modifiers & Inheritance", "Payable functions")),
                CurriculumModule("Module 3: Security & Attacks", listOf("Reentrancy vulnerability", "Front-running and MEV", "Automated static analysis"))
            ),
            resources = listOf(
                SpecializationResource(
                    id = "res-block-1",
                    title = "Patrick Collins Solidity & Foundry Course",
                    provider = "Patrick Collins / FreeCodeCamp",
                    accessCost = "100% Free",
                    language = LanguageBadge.ENGLISH,
                    url = "https://www.youtube.com/results?search_query=Patrick+Collins+Solidity+Full+Course",
                    difficulty = Difficulty.BEGINNER,
                    description = "Comprehensive 32-hour practical curriculum covering Foundry, Solidity, and smart contract security."
                )
            ),
            projects = listOf(
                SpecializationProject(
                    name = "Crowdfunding dApp on Sepolia Testnet",
                    difficulty = Difficulty.INTERMEDIATE,
                    description = "Smart contract with contribution milestones, refund guarantees, and Next.js web frontend.",
                    tech = listOf("Solidity", "Foundry", "Next.js", "Ethers.js")
                )
            ),
            portfolioAdvice = listOf(
                "Deploy contracts to public testnets (Sepolia) and link the verified Etherscan source code in your README.",
                "Include automated unit test suites written in Foundry."
            ),
            careerGuidance = "High remote compensation opportunities for engineers with deep understanding of smart contract security."
        ),
        Specialization(
            id = "game-dev",
            title = "Game Development & Graphics",
            slug = "game-development",
            iconKey = "gamepad",
            tagline = "Real-time 3D rendering engines, physics simulations, and interactive gameplay systems.",
            prerequisites = listOf("C++ or C#", "Vector Mathematics & Linear Algebra"),
            roadmap = listOf(
                RoadmapPhase("Phase 1", "2D Engines & Math", "Vector maths, 2D coordinates, game loops, Godot or Unity 2D.", listOf("C#", "Godot", "Unity")),
                RoadmapPhase("Phase 2", "3D Gameplay Systems", "Rigid bodies, colliders, raycasting, materials, and audio managers.", listOf("Unity 3D", "Unreal Engine")),
                RoadmapPhase("Phase 3", "Graphics & Shaders", "OpenGL / WebGL pipeline, GLSL shaders, lighting models (Phong, PBR).", listOf("GLSL", "OpenGL", "Shaders")),
                RoadmapPhase("Phase 4", "Optimization & AI", "A* Pathfinding, state machines, and memory profiling for 60fps.", listOf("C++", "Optimization"))
            ),
            curriculum = listOf(
                CurriculumModule("Module 1: Game Engine Core", listOf("Entity-Component system", "Delta time & frame independence", "Input polling")),
                CurriculumModule("Module 2: Shaders & Graphics", listOf("Vertex and Fragment shaders", "UV texture mapping", "Camera matrices")),
                CurriculumModule("Module 3: Game Mechanics", listOf("NPC behavior trees", "Inventory serialization", "Object pooling"))
            ),
            resources = listOf(
                SpecializationResource(
                    id = "res-game-1",
                    title = "LearnOpenGL Tutorials",
                    provider = "Joey de Vries",
                    accessCost = "100% Free",
                    language = LanguageBadge.ENGLISH,
                    url = "https://learnopengl.com/",
                    difficulty = Difficulty.INTERMEDIATE,
                    description = "The gold standard book and code tutorials for understanding modern OpenGL and graphics pipelines."
                )
            ),
            projects = listOf(
                SpecializationProject(
                    name = "3D Physics Puzzle Platformer",
                    difficulty = Difficulty.INTERMEDIATE,
                    description = "Complete 3D game with custom physics triggers, particle effects, and 5 progressive stages.",
                    tech = listOf("Unity", "C#", "Blender")
                )
            ),
            portfolioAdvice = listOf(
                "Publish playable WebGL builds directly on Itch.io so anyone can play in their browser without downloading.",
                "Showcase 15-second gameplay action clips on LinkedIn."
            ),
            careerGuidance = "Growing game studio ecosystem in India along with international simulation and AR/VR enterprises."
        ),
        Specialization(
            id = "iot-embedded",
            title = "IoT, Embedded Systems & Robotics",
            slug = "iot-robotics",
            iconKey = "cpu",
            tagline = "Bridge physical electronics with microcontrollers, real-time operating systems, and telemetry.",
            prerequisites = listOf("C Programming", "Basic Electronics (Ohm's Law, GPIO)"),
            roadmap = listOf(
                RoadmapPhase("Phase 1", "Microcontrollers", "Arduino / ESP32, GPIO reading, ADC, serial communication.", listOf("C/C++", "ESP32", "Arduino")),
                RoadmapPhase("Phase 2", "Hardware Protocols", "UART, I2C, SPI interfaces, sensor datasheets, and PWM motor drivers.", listOf("I2C", "SPI", "PWM")),
                RoadmapPhase("Phase 3", "IoT & Cloud Telemetry", "WiFi/BLE modules, MQTT protocol, sending sensor data to AWS IoT.", listOf("MQTT", "FreeRTOS", "ESP-IDF")),
                RoadmapPhase("Phase 4", "RTOS & Robotics", "FreeRTOS task scheduling, ROS2 basics, PID control loops.", listOf("FreeRTOS", "ROS2", "PID"))
            ),
            curriculum = listOf(
                CurriculumModule("Module 1: Embedded Architecture", listOf("Interrupt service routines (ISR)", "SRAM vs Flash memory", "Deep sleep modes")),
                CurriculumModule("Module 2: Communication Busses", listOf("I2C addressing & clock stretching", "SPI full-duplex transfers", "Logic analyzer debugging")),
                CurriculumModule("Module 3: Real-Time Systems", listOf("Tasks, queues, and semaphores", "Deterministic scheduling", "Sensor fusion"))
            ),
            resources = listOf(
                SpecializationResource(
                    id = "res-iot-1",
                    title = "Introduction to Embedded Systems Software",
                    provider = "University of Colorado Boulder / Coursera",
                    accessCost = "Free Audit Available",
                    language = LanguageBadge.ENGLISH,
                    url = "https://www.coursera.org/learn/introduction-embedded-systems",
                    difficulty = Difficulty.BEGINNER,
                    description = "In-depth guide to registers, memory mapping, and embedded C compilation."
                )
            ),
            projects = listOf(
                SpecializationProject(
                    name = "ESP32 IoT Environmental Station",
                    difficulty = Difficulty.BEGINNER,
                    description = "Telemetry station measuring temperature, humidity, and air quality streaming via MQTT to a live dashboard.",
                    tech = listOf("ESP32", "C++", "MQTT", "Node-RED")
                )
            ),
            portfolioAdvice = listOf(
                "Include clean wiring diagrams and schematics alongside your code repository.",
                "Embed a video clip demonstrating real physical hardware responsiveness."
            ),
            careerGuidance = "High hiring in semiconductor (Qualcomm, Intel, TI), automotive, drone, and industrial automation firms in India."
        ),
        Specialization(
            id = "quantum",
            title = "Quantum Computing",
            slug = "quantum-computing",
            iconKey = "atom",
            tagline = "Harness qubits, superposition, entanglement, and next-generation computational algorithms.",
            prerequisites = listOf("Linear Algebra (Hermitian matrices)", "Complex Numbers", "Python"),
            roadmap = listOf(
                RoadmapPhase("Phase 1", "Mathematical Core", "Complex vector spaces, Dirac bra-ket notation, unitary operators.", listOf("Linear Algebra", "Dirac Notation")),
                RoadmapPhase("Phase 2", "Qubits & Single Gates", "Bloch Sphere, Pauli gates (X, Y, Z), Hadamard gate, measurement collapse.", listOf("Qubits", "Quantum Gates")),
                RoadmapPhase("Phase 3", "Multi-Qubit Circuits", "Bell states, Quantum Teleportation, Deutsch-Jozsa, Grover search.", listOf("Qiskit", "Grover Algorithm")),
                RoadmapPhase("Phase 4", "Quantum Algorithms", "Quantum Fourier Transform (QFT), Shor's algorithm, VQE optimization.", listOf("PennyLane", "VQE"))
            ),
            curriculum = listOf(
                CurriculumModule("Module 1: Quantum Foundations", listOf("Superposition & Measurement", "Bloch sphere state representation", "No-cloning theorem")),
                CurriculumModule("Module 2: Qiskit Circuits", listOf("Building quantum registers", "Entangling qubits with CNOT", "Executing on IBM Quantum cloud")),
                CurriculumModule("Module 3: Speedup & Algorithms", listOf("Quantum Fourier Transform", "Phase Estimation", "Grover amplitude amplification"))
            ),
            resources = listOf(
                SpecializationResource(
                    id = "res-quantum-1",
                    title = "Qiskit Quantum Computing Textbook",
                    provider = "IBM Quantum",
                    accessCost = "100% Free",
                    language = LanguageBadge.ENGLISH,
                    url = "https://learn.qiskit.org/",
                    difficulty = Difficulty.BEGINNER,
                    description = "Interactive open textbook teaching quantum computation using Python and real IBM Quantum hardware."
                )
            ),
            projects = listOf(
                SpecializationProject(
                    name = "Quantum Teleportation Circuit Simulation",
                    difficulty = Difficulty.INTERMEDIATE,
                    description = "Simulate 3-qubit state teleportation circuit with Qiskit and visualize state tomography measurements.",
                    tech = listOf("Python", "Qiskit", "Matplotlib")
                )
            ),
            portfolioAdvice = listOf(
                "Run experimental jobs on real IBM Quantum devices (free tier) and compare output distributions against noiseless simulators.",
                "Summarize research papers into concise technical README writeups."
            ),
            careerGuidance = "National research organizations (DRDO, ISRO), university labs, and specialized quantum research teams at IBM and Microsoft."
        ),
        Specialization(
            id = "advanced-core-cs",
            title = "Advanced Core Computer Science",
            slug = "advanced-core-cs",
            iconKey = "terminal",
            tagline = "Delve into compilers, formal automata theory, distributed consensus, and kernel internals.",
            prerequisites = listOf("Data Structures & Algorithms", "C/C++", "Discrete Mathematics"),
            roadmap = listOf(
                RoadmapPhase("Phase 1", "Automata & Formal Languages", "DFA, NFA, Context-Free Grammars, Pushdown Automata, Turing Machines.", listOf("Theory of Computation", "Turing Machines")),
                RoadmapPhase("Phase 2", "Compiler Construction", "Lexical analysis (Flex), parsing (Bison), ASTs, intermediate 3-address code.", listOf("LLVM", "Flex/Bison", "C++")),
                RoadmapPhase("Phase 3", "Distributed Systems", "CAP theorem, Raft consensus algorithm, vector clocks, RPCs, fault tolerance.", listOf("Raft", "gRPC", "Distributed")),
                RoadmapPhase("Phase 4", "Systems Performance", "Lock-free algorithms, cache profiling, Linux kernel modules.", listOf("eBPF", "Kernel Modules", "Assembly"))
            ),
            curriculum = listOf(
                CurriculumModule("Module 1: Automata Theory", listOf("Regular expressions to DFA", "Pumping Lemma for CFLs", "Halting Problem & Undecidability")),
                CurriculumModule("Module 2: Compiler Design", listOf("LL(1) and LR(1) parsing tables", "Semantic analysis and Symbol tables", "Register allocation")),
                CurriculumModule("Module 3: Distributed Coordination", listOf("Leader election protocols", "Consensus via Raft", "Eventual consistency models"))
            ),
            resources = listOf(
                SpecializationResource(
                    id = "res-core-1",
                    title = "MIT 6.824: Distributed Systems",
                    provider = "MIT OpenCourseWare / Robert Morris",
                    accessCost = "100% Free",
                    language = LanguageBadge.ENGLISH,
                    url = "https://pdos.csail.mit.edu/6.824/",
                    difficulty = Difficulty.ADVANCED,
                    description = "Famous MIT course covering MapReduce, Raft consensus, fault tolerance, and distributed transactions."
                )
            ),
            projects = listOf(
                SpecializationProject(
                    name = "Custom Programming Language Tree-Walk Interpreter",
                    difficulty = Difficulty.ADVANCED,
                    description = "Build an interpreter with custom syntax, lexer, AST parser, variables, loops, and closures in C++.",
                    tech = listOf("C++", "Lexing", "AST", "Compilers")
                )
            ),
            portfolioAdvice = listOf(
                "Write technical RFC-style design docs detailing edge cases and performance trade-offs.",
                "Include benchmark graphs comparing your implementation against standard baselines."
            ),
            careerGuidance = "Essential for systems engineers, database engine developers, GATE CSE top rankers, and MS/PhD applicants."
        )
    )
}
