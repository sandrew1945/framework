package com.sandrew.bootsec.bean.esign;

/**
 *  经办人注册输入参数
 */
public class OperatorRegInput
{
    private OperatorInfo operatorInfo = new OperatorInfo();


    public OperatorInfo getOperatorInfo()
    {
        return operatorInfo;
    }

    public void setOperatorInfo(OperatorInfo operatorInfo)
    {
        this.operatorInfo = operatorInfo;
    }


    public void setMobile(String mobile)
    {
        this.operatorInfo.setMobile(mobile);
    }

    public void setCardType(String cardType)
    {
        this.operatorInfo.setCardType(cardType);
    }

    public void setCardNo(String cardNo)
    {
        this.operatorInfo.setCardNo(cardNo);
    }


    public void setName(String name)
    {
        this.operatorInfo.setName(name);
    }

    public void setEmail(String email)
    {
        this.operatorInfo.setEmail(email);
    }

    public void setOperatorNo(String operatorNo)
    {
        this.operatorInfo.setOperatorNo(operatorNo);
    }

    class OperatorInfo {
        /**
         * 经办人手机号
         */
        String mobile;

        /**
         * 证件类型
         */
        String cardType;

        /**
         * 证件号
         */
        String cardNo;

        /**
         * 姓名
         */
        String name;

        /**
         * 经办人邮箱
         */
        String email;

        /**
         * 代销经办人编号
         */
        String operatorNo;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getOperatorNo() {
            return operatorNo;
        }

        public void setOperatorNo(String operatorNo) {
            this.operatorNo = operatorNo;
        }
    }
}
