# 递归(recursion)
去的过程叫“递”，回来的过程叫“归”。

递归是借助栈来实现的，使用的栈是系统或者虚拟机本身提供的

递归代码要警惕堆栈溢出
函数调用会使用栈来保存临时变量。每调用一个函数，都会将临时变量封装为栈帧压入内存栈，等函数执行完成返回时，才出栈。
系统栈或者虚拟机栈空间一般都不大。如果递归求解的数据规模很大，调用层次很深，一直压入栈，就会有堆栈溢出的风险。

为了避免重复计算，我们可以通过一个数据结构（比如散列表）来保存已经求解过的 f(k)。当递归调用到 f(k) 时，
先看下是否已经求解过了。如果是，则直接从散列表中取值返回，不需要重复计算
