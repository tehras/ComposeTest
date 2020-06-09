package com.github.tehras.player.search

import android.os.Parcelable
import com.github.tehras.player.search.PlayerSearchState.DisplayingSearch
import com.github.tehras.player.search.PlayerSearchState.SearchingForPlayer
import com.github.tehras.uicommon.renderings.LoadingRendering
import com.github.tehras.uicommon.toParcelable
import com.github.tehras.uicommon.toSnapshot
import com.squareup.workflow.RenderContext
import com.squareup.workflow.Snapshot
import com.squareup.workflow.StatefulWorkflow
import com.squareup.workflow.action
import kotlinx.android.parcel.Parcelize

sealed class PlayerSearchState : Parcelable {
    @Parcelize
    object DisplayingSearch : PlayerSearchState()

    @Parcelize
    data class SearchingForPlayer(val playerText: String) : PlayerSearchState()
}

class PlayerSearchWorkflow() :
    StatefulWorkflow<Unit, PlayerSearchState, Unit, Any>() {
    override fun initialState(props: Unit, snapshot: Snapshot?): PlayerSearchState =
        snapshot?.toParcelable() ?: DisplayingSearch

    override fun render(
        props: Unit,
        state: PlayerSearchState,
        context: RenderContext<PlayerSearchState, Unit>
    ): Any {
        val sink = context.actionSink
        return when (state) {
            DisplayingSearch -> PlayerSearchRendering { value ->
                sink.send(action { nextState = SearchingForPlayer(value) })
            }
            is SearchingForPlayer -> LoadingRendering(
                text = "Retrieving Data",
                onBack = { sink.send(action { nextState = DisplayingSearch }) }
            )
        }
    }

    override fun snapshotState(state: PlayerSearchState): Snapshot = state.toSnapshot()
}