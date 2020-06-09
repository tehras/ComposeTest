package com.github.tehras.valorantstats

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.material.MaterialTheme
import com.github.tehras.player.search.PlayerSearchBinding
import com.github.tehras.uicommon.renderings.LoadingRenderingBinding
import com.github.tehras.valorantstats.home.HomeWorkflow
import com.squareup.workflow.diagnostic.SimpleLoggingDiagnosticListener
import com.squareup.workflow.ui.ViewEnvironment
import com.squareup.workflow.ui.ViewRegistry
import com.squareup.workflow.ui.WorkflowRunner
import com.squareup.workflow.ui.compose.withCompositionRoot
import com.squareup.workflow.ui.setContentWorkflow
import org.koin.android.ext.android.inject

private val viewRegistry = ViewRegistry(LoadingRenderingBinding, PlayerSearchBinding)
private val containerHints = ViewEnvironment(viewRegistry)
    .withCompositionRoot { content -> MaterialTheme(content = content) }

class MainWorkflowActivity : AppCompatActivity() {

    private val homeWorkflow: HomeWorkflow by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentWorkflow(containerHints) {
            WorkflowRunner.Config(
                workflow = homeWorkflow,
                diagnosticListener = SimpleLoggingDiagnosticListener()
            )
        }
    }
}