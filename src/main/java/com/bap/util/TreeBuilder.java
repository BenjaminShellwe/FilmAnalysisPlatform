package com.bap.util;


/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.bap.system.dto.model.MenuVO;
import com.bap.system.dto.output.SystemUrlTreeNode;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TreeBuilder {

    public static Set<MenuVO> buildTree(Set<MenuVO> allNodes) {
        // 根节点
        Set<MenuVO> root = new HashSet<>();
        allNodes.forEach(node -> {
            if (Integer.valueOf( node.getParentId() ) == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findChildren(node, allNodes);
        });
        return root;
    }


    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private static MenuVO findChildren(MenuVO treeNode, Set<MenuVO> treeNodes) {
        for (MenuVO it : treeNodes) {
            if (String.valueOf( treeNode.getId() ).equals(it.getParentId())) {
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

    public static List<SystemUrlTreeNode> buildMenuTree(List<SystemUrlTreeNode> allNodes) {
        // 根节点
        List<SystemUrlTreeNode> root = Lists.newArrayList();
        allNodes.forEach(node -> {
            if (Integer.valueOf( node.getParentId() ) == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findMenuChildren(node, allNodes);
        });

        //对根节点排序
        List<SystemUrlTreeNode> sortedList = root.stream().sorted( Comparator.comparing( SystemUrlTreeNode::getSortNo ) ).collect( Collectors.toList());
        //先清空，在添加
        root.clear();
        root.addAll( sortedList );
        return root;
    }


    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private static SystemUrlTreeNode findMenuChildren(SystemUrlTreeNode treeNode, List<SystemUrlTreeNode> treeNodes) {
        for (SystemUrlTreeNode it : treeNodes) {
            if (String.valueOf( treeNode.getId() ).equals(it.getParentId())) {
                treeNode.getChildren().add(findMenuChildren(it, treeNodes));
            }
        }
        //对子节点排序
        List<SystemUrlTreeNode> childrenSorted = treeNode.getChildren().stream().sorted( Comparator.comparing( SystemUrlTreeNode::getSortNo ) ).collect( Collectors.toList());
        //先清空，在添加
        treeNode.getChildren().clear();
        treeNode.getChildren().addAll( childrenSorted );
        return treeNode;
    }


}
