package com.example.aicommit

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project

class ConventionalCommitToggleAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val project: Project = event.project ?: return
        val userSettings = project.service<UserSettings>()

        // Toggle the state of Conventional Commits
        userSettings.isConventionalCommitsEnabled = !userSettings.isConventionalCommitsEnabled
        val newState = if (userSettings.isConventionalCommitsEnabled) {
            "enabled"
        } else {
            "disabled"
        }

        // Display the new state of the toggle
        println("Conventional Commits are now $newState.")
    }
}

interface UserSettings {
    var isConventionalCommitsEnabled: Boolean
}