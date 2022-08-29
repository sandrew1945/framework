package com.sandrew.bootsec.bean.esign;

/** 代销机构项目-经办人关系信息同步输入参数 */
public class RelationsExpandInput {
  private RelationsExpand relations = new RelationsExpand();

  public RelationsExpand getRelations() {
    return relations;
  }

  public void setRelations(RelationsExpand relations) {
    this.relations = relations;
  }
}
