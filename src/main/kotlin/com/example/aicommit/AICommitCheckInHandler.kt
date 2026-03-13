package com.example.aicommit

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.vcs.CheckinProjectPanel
import com.intellij.openapi.vcs.checkin.CheckinHandler
import com.intellij.openapi.vcs.checkin.CheckinHandler.ReturnResult
import com.intellij.openapi.vcs.ui.RefreshableOnComponent
import javax.swing.JComponent

class AICommitCheckInHandler(private val project: Project, private val checkinPanel: CheckinProjectPanel) : CheckinHandler() {
    override fun getBeforeCheckinConfigurationPanel(): RefreshableOnComponent {
        return AICommitPanel(project, checkinPanel)
    }

    override fun beforeCheckin(): ReturnResult {
        return ReturnResult.COMMIT
    }
}
