package com.example.data

import com.example.model.CompanyTrack
import com.example.model.PlacementMilestone

object PlacementData {
    val milestones: List<PlacementMilestone> = listOf(
        PlacementMilestone(
            semester = "Semesters 1 & 2",
            focus = "Language Fluency & Foundations",
            actionItems = listOf(
                "Pick one primary language (C or C++) and master memory addresses, arrays, and functions.",
                "Learn Linux command line navigation and basic Git commit/push commands.",
                "Maintain university CGPA >= 7.5 (eligibility threshold for 90%+ companies in India)."
            )
        ),
        PlacementMilestone(
            semester = "Semesters 3 & 4",
            focus = "DSA Foundations & Core CS",
            actionItems = listOf(
                "Solve 150+ standard problems on Track A (Arrays, Strings, HashMaps, Linked Lists, Trees).",
                "Study Operating Systems (threads, paging) and DBMS (SQL joins, normalization) rigorously.",
                "Build 1 real original project (not a copy-pasted tutorial) and push to GitHub."
            )
        ),
        PlacementMilestone(
            semester = "Semester 5",
            focus = "Specialization & ATS Resume",
            actionItems = listOf(
                "Tackle dynamic programming and graph algorithms on Track B.",
                "Pick 1 specialization track (Fullstack, AI/ML, Cloud) and deploy an end-to-end project with database.",
                "Draft an ATS-compliant single-column resume using standard LaTeX or Google Docs templates."
            )
        ),
        PlacementMilestone(
            semester = "Semester 6",
            focus = "Internships & Online Assessments (OA)",
            actionItems = listOf(
                "Practice timed 60-90 minute mock coding tests on HackerRank and LeetCode contest mode.",
                "Revise Quantitative Aptitude and Logical Reasoning (Indiabix / RS Aggarwal).",
                "Apply for summer internships via LinkedIn, Wellfound, and official career portals."
            )
        ),
        PlacementMilestone(
            semester = "Semesters 7 & 8",
            focus = "Full-time Placement Drives & Technical Rounds",
            actionItems = listOf(
                "Conduct 10+ peer mock interviews practicing thinking out loud and live whiteboard coding.",
                "Prepare crisp 2-minute project elevator pitches detailing technical challenges, DB schemas, and metrics.",
                "Prepare for HR & Behavioral rounds using the STAR method (Situation, Task, Action, Result)."
            )
        )
    )

    val companyTracks: List<CompanyTrack> = listOf(
        CompanyTrack(
            companyTier = "Tier 3: Mass Recruiters & Service Companies",
            examples = "TCS (NQT), Infosys, Wipro, Cognizant, Accenture, Capgemini",
            hiringProcess = "Round 1: Cognitive Aptitude + Basic Coding. Round 2: Combined Tech & HR Interview.",
            keyFocus = listOf(
                "Speed in quantitative aptitude, series, speed/time, and verbal logic.",
                "Basic array manipulations, palindrome strings, and pattern printing.",
                "Clear verbal communication, polite demeanor, and OOP fundamentals."
            ),
            freePracticeLink = "https://www.indiabix.com/"
        ),
        CompanyTrack(
            companyTier = "Tier 2: Product Companies & High-Growth Startups",
            examples = "Flipkart, Swiggy, Zomato, Razorpay, PhonePe, CRED, BrowserStack",
            hiringProcess = "Round 1: 3-Problem OA. Round 2 & 3: DSA Live Coding. Round 4: Machine Coding (LLD). Round 5: Culture Fit.",
            keyFocus = listOf(
                "Medium-to-hard DSA: DP, Graphs, Segment Trees, Sliding Window.",
                "Machine coding: Implement clean OOP design (e.g. Parking Lot, Snake & Ladder) within 90 mins.",
                "Deep knowledge of project architecture, concurrency, and DB schemas."
            ),
            freePracticeLink = "https://leetcode.com/problemset/all/"
        ),
        CompanyTrack(
            companyTier = "Tier 1: Big Tech (FAANG / Tier 1 Global)",
            examples = "Google, Microsoft, Amazon, Adobe, Atlassian, Uber, Salesforce",
            hiringProcess = "Round 1: OA. Rounds 2-4: Pure DSA + Problem Solving. Round 5: Behavioral (e.g. Amazon Leadership Principles).",
            keyFocus = listOf(
                "Optimal Big-O time and space complexity with clean, modular, bug-free code.",
                "Thinking out loud, clarifying constraints, and handling edge cases.",
                "Deep mastery of edge cases: integer overflow, empty inputs, graph cycles."
            ),
            freePracticeLink = "https://cses.fi/problemset/"
        )
    )
}
