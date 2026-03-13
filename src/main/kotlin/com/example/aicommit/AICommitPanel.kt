package com.example.aicommit

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.vcs.CheckinProjectPanel
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBLabel
import com.intellij.util.ui.JBUI
import com.intellij.openapi.vcs.ui.RefreshableOnComponent
import java.awt.BorderLayout
import javax.swing.JComponent
import javax.swing.JPanel

class AICommitPanel(
    project: Project,
    private val checkinPanel: CheckinProjectPanel
) : RefreshableOnComponent {
    private val panel = JPanel(BorderLayout())
    private val checkbox = JBCheckBox("✨ AI Commit")
    private val settings = project.service<AICommitSettings>()
    private var originalMessage = ""
    private var isProcessing = false

    init {
        checkbox.isSelected = settings.isEnabled
        setupPanel()
        setupCheckboxListener()
    }

    private fun setupPanel() {
        panel.border = JBUI.Borders.empty(5)
        val label = JBLabel("勾选后自动添加 #AI commit# 标识")
        val wrapper = JBUI.Panels.simplePanel()
            .addToLeft(checkbox)
            .addToCenter(label)
        panel.add(wrapper, BorderLayout.WEST)
    }

    private fun setupCheckboxListener() {
        checkbox.addActionListener {
            if (isProcessing) return@addActionListener
            val currentMessage = checkinPanel.commitMessage
            if (checkbox.isSelected) {
                originalMessage = currentMessage
                if (!currentMessage.contains(AI_COMMIT_TAG)) {
                    val newMessage = currentMessage.trimEnd() + " " + AI_COMMIT_TAG
                    isProcessing = true
                    checkinPanel.setCommitMessage(newMessage)
                    isProcessing = false
                }
            } else {
                if (currentMessage.endsWith(AI_COMMIT_TAG)) {
                    isProcessing = true
                    checkinPanel.setCommitMessage(originalMessage)
                    isProcessing = false
                }
            }
            settings.isEnabled = checkbox.isSelected
        }
    }

    override fun getComponent(): JComponent = panel

    override fun refresh() {}

    override fun saveState() {}

    @Deprecated("Deprecated in RefreshableOnComponent", ReplaceWith(""))
    override fun restoreState() {}

    companion object {
        private const val AI_COMMIT_TAG = "#AI commit#"
    }
}
