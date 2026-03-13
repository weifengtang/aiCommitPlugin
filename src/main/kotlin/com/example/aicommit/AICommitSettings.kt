package com.example.aicommit

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
@State(name = "AICommitSettings", storages = [Storage("aiCommitSettings.xml")])
class AICommitSettings : PersistentStateComponent<AICommitSettings.State> {
    data class State(
        var isEnabled: Boolean = false
    )

    private var state = State()

    override fun getState(): State = state

    override fun loadState(state: State) {
        this.state = state
    }

    var isEnabled: Boolean
        get() = state.isEnabled
        set(value) {
            state.isEnabled = value
        }
}
