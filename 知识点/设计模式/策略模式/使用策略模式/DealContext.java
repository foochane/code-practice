package 设计模式.策略模式.使用策略模式;

//定义上下文，负责使用DealStrategy角色
public  class DealContext{
    private String type;
    private DealStrategy deal;
    public  DealContext(String type,DealStrategy deal){
        this.type = type;
        this.deal = deal;
    }
    public DealStrategy getDeal(){
        return deal;
    }
    public boolean options(String type){
        return this.type.equals(type);
    }
}
