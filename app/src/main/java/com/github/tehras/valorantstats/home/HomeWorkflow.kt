package com.github.tehras.valorantstats.home

import com.github.tehras.player.search.PlayerSearchWorkflow
import com.squareup.workflow.RenderContext
import com.squareup.workflow.StatelessWorkflow
import com.squareup.workflow.action

class HomeWorkflow(
    private val playerSearchWorkflow: PlayerSearchWorkflow
) : StatelessWorkflow<Unit, Nothing, Any>() {
    override fun render(props: Unit, context: RenderContext<Nothing, Nothing>): Any {
        return context.renderChild(
            child = playerSearchWorkflow,
            props = Unit,
            handler = { action { /* TODO(Has to return Nothing?) */ } }
        )
    }
}