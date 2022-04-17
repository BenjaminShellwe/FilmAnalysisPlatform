package com.bap.system.dto.output;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:40
 */

import com.google.common.collect.Lists;
import com.bap.system.entity.SystemUrl;
import lombok.Data;

import java.util.List;

/**
 *  <p> 菜单树节点 </p>
 *
 */
@Data
public class SystemUrlTreeNode extends SystemUrl {

    List<SystemUrlTreeNode> children = Lists.newArrayList();

}
