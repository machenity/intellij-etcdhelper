package com.github.tsonglew.etcdhelper.render

import com.intellij.icons.AllIcons
import com.intellij.openapi.util.Iconable.IconFlags
import com.intellij.ui.ColoredTreeCellRenderer
import javax.swing.JTree
import javax.swing.tree.DefaultMutableTreeNode
import javax.xml.crypto.dsig.keyinfo.KeyInfo

class KeyTreeCellRenderer: ColoredTreeCellRenderer() {
    override fun customizeCellRenderer(
        tree: JTree,
        value: Any?,
        selected: Boolean,
        expanded: Boolean,
        leaf: Boolean,
        row: Int,
        hasFocus: Boolean
    ) {
        val node = value as DefaultMutableTreeNode
        val userObj = node.userObject
        append(node.toString())
        icon = when {
            row == 0 -> AllIcons.Debugger.Db_array
            leaf && userObj is KeyInfo -> AllIcons.Debugger.Value
            else -> AllIcons.Nodes.Folder
        }
    }
}
