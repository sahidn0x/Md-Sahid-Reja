package com.example.data

import com.example.model.Difficulty
import com.example.model.ProjectBlueprint

object ProjectsCareersData {
    val blueprints: List<ProjectBlueprint> = listOf(
        ProjectBlueprint(
            id = "proj-1",
            title = "Real-Time Collaborative Code & Markdown Editor",
            category = "Web Development",
            difficulty = Difficulty.INTERMEDIATE,
            prerequisites = listOf("React or Vue", "Node.js/Express", "WebSockets"),
            learningObjectives = listOf(
                "Implement bidirectional event streaming using WebSockets / Socket.io",
                "Manage synchronized document state across multiple connected clients",
                "Build isolated room routing with unique document hash links"
            ),
            steps = listOf(
                "Step 1: Set up Express backend with Socket.io server and room subscription handlers.",
                "Step 2: Build a React client integrating Monaco Editor (VS Code core engine).",
                "Step 3: Broadcast document change patches only to clients connected to the same room hash.",
                "Step 4: Add syntax highlighting and a live side-by-side rendered Markdown preview panel.",
                "Step 5: Store saved documents into PostgreSQL / MongoDB database with timestamped revisions."
            ),
            tools = listOf("React", "TypeScript", "Node.js", "Socket.io", "Monaco Editor", "Tailwind CSS"),
            testingChecklist = listOf(
                "Open two browser windows side by side and confirm keystroke synchronization without lag.",
                "Verify reconnect behavior when network is temporarily disconnected."
            ),
            readmeOutline = listOf(
                "Project Overview & Live Demo Link",
                "Architecture Diagram of WebSocket event propagation",
                "Local setup instructions (npm install & .env configuration)",
                "API Endpoints & Socket Events Specification"
            ),
            extensions = listOf(
                "Add WebRTC audio chat for peer programming.",
                "Integrate Judge0 free API for in-browser multi-language code execution."
            )
        ),
        ProjectBlueprint(
            id = "proj-2",
            title = "Intelligent Resume ATS Parser & Skill Gap Analyzer",
            category = "AI / Machine Learning",
            difficulty = Difficulty.INTERMEDIATE,
            prerequisites = listOf("Python", "NLP Basics", "Streamlit or FastAPI"),
            learningObjectives = listOf(
                "Extract structured text from multi-column PDF resumes",
                "Calculate cosine similarity between candidate resume and job descriptions",
                "Identify and flag missing technical keywords to the user"
            ),
            steps = listOf(
                "Step 1: Parse uploaded PDF/DOCX files using PyPDF2 and pdfplumber.",
                "Step 2: Clean text by removing stopwords, punctuation, and non-ASCII symbols.",
                "Step 3: Generate sentence embeddings using sentence-transformers or TF-IDF vectors.",
                "Step 4: Compute cosine similarity score between the resume text and the Target Job Description.",
                "Step 5: Highlight missing keywords and display match percentage in an interactive UI."
            ),
            tools = listOf("Python", "PyPDF2", "Scikit-Learn", "Sentence-Transformers", "Streamlit"),
            testingChecklist = listOf(
                "Test multi-column PDF layouts to verify correct reading order.",
                "Validate that matching score increases predictably when known keywords are inserted."
            ),
            readmeOutline = listOf(
                "Problem Statement: Why ATS matters for Indian freshers",
                "NLP Pipeline explanation with vector diagrams",
                "How to run locally via `streamlit run app.py`"
            ),
            extensions = listOf(
                "Add an open-source LLM suggestion engine that rewrites weak bullet points using action verbs."
            )
        ),
        ProjectBlueprint(
            id = "proj-3",
            title = "Cloud Microservices URL Shortener & Analytics API",
            category = "Cloud & Backend",
            difficulty = Difficulty.INTERMEDIATE,
            prerequisites = listOf("Go or Node.js", "Redis", "PostgreSQL", "Docker"),
            learningObjectives = listOf(
                "Build high-throughput Base62 hashing algorithm",
                "Implement Redis caching layer for sub-5ms redirects",
                "Collect click analytics (referrer, geography, user agent) asynchronously"
            ),
            steps = listOf(
                "Step 1: Design PostgreSQL database schema for URLs and click logs.",
                "Step 2: Implement Base62 encoding service to convert incremental IDs to 7-character slugs.",
                "Step 3: Cache popular redirect lookups in Redis with automatic TTL expiration.",
                "Step 4: Push click events into a message queue to prevent write contention.",
                "Step 5: Containerize services with Docker Compose and set up Nginx reverse proxy."
            ),
            tools = listOf("Go", "PostgreSQL", "Redis", "Docker", "Nginx"),
            testingChecklist = listOf(
                "Run Apache Bench (ab) or k6 to benchmark redirect latency under 1000 concurrent requests.",
                "Verify cache hits vs cache misses in Redis monitor."
            ),
            readmeOutline = listOf(
                "System Architecture & Data Flow Diagram",
                "Database Indexing Strategy",
                "Docker Compose Quickstart instructions"
            ),
            extensions = listOf(
                "Add custom vanity slugs and expiration dates for generated short links."
            )
        )
    )

    val tier2Tier3Advice: List<Pair<String, String>> = listOf(
        "Direct Cold Outreach with Value" to "Never send generic 'Please give me a job' messages on LinkedIn. Find open issues in a startup's public GitHub repo or build a small prototype fixing an obvious bug in their product before reaching out to engineering leads.",
        "Highlight Production Links Over Certificates" to "Recruiters and hiring managers from top startups do not care about 20 generic completion certificates. A single live deployed fullstack application with authentic users and a clean GitHub repo carries 10x more weight.",
        "Hackathons & Coding Competitions" to "Participate actively in Smart India Hackathon (SIH), MLH hackathons, and LeetCode bi-weekly contests. Achieving a top-5% contest rating or winning a hackathon bypasses college brand bias completely.",
        "Open Source Contribution" to "Start by fixing documentation and good-first-issues in popular open-source libraries. Having merged Pull Requests in recognized repositories proves that you can navigate large existing codebases."
    )
}
