package org.spek.impl

import org.spek.*

open class OnImpl: On {
    private val recordedActions = linkedListOf<TestItAction>()

    public fun iterateIt(it : (TestItAction) -> Unit) : Unit = removingIterator(recordedActions, it)

    public override fun it(description: String, itExpression: It.()->Unit) {
        recordedActions.add(
                object : TestItAction {
                    public override fun description() = "it " + description
                    public override fun run() = ItImpl().itExpression()
                })
    }
}

