package com.example.aicommit

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAware

class ConventionalCommitToggleAction : AnAction(), DumbAware {
    override fun actionPerformed(e: AnActionEvent) {
        // TODO: Implement the action's behavior
        println("Conventional commit toggle action performed.")
    }

    override fun update(e: AnActionEvent) {
        // TODO: Update action's presentation based on the context
        e.presentation.isEnabled = true
    }
}