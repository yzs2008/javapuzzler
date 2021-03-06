## 建造者模式
`建造者模式：是将一个复杂的对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。`

**建造者模式通常包含下面几个角色：**
> 1. builder 给出一个抽象接口，以规范产品对象的各组成部分的创建。
> 2. concreteBuilder 实现builder接口，针对不同的逻辑，创建具体的，符合规范的产品。
> 3. product 建造者创建出来的具体产品。
>> `ps. directorTest 是模式调用demo`

建造者模式可以保证按照规范流程创建对象，如果有一个对象需要严格控制其创建流程，首先考虑使用建造者模式。
在对象没有严格要求创建的条件时，建造者模式和普通的创建，抽象工厂模式都十分相似。

什么时候使用建造者模式呢？`The builder pattern is a good choice when designing classes whose constructors or static factories would have more than a handful of parameters`引自《effective java》构造一个对象有很多构造参数时，就是使用建造者模式的好时机，工厂模式更倾向于少量参数构造对象的情景

建造者模式结构图：

![建造者模式结构图](http://pic002.cnblogs.com/images/2012/406683/2012071919460471.jpg)

其中builder中包含创建product的所有参数，在concreteBuilder中配置这些参数，达到产出不同产品的效果
