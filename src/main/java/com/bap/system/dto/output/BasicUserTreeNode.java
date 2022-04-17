package com.bap.system.dto.output;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:39
 */

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.bap.system.entity.BasicUser;

import java.util.List;

/**
 *  <p> 用户树节点 </p>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BasicUserTreeNode extends BasicUser {

    List<BasicUserTreeNode> children = Lists.newArrayList();

}
