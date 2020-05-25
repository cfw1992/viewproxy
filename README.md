# 基于普通的View开发替换Fragment的思考
## 简介


Fragment是google开发出的碎片化方案,可以将界面拆分成很多的模块进行组合开发，提高了代码复用率和程序的效率。但是使用中存在一些各种各样的问题,
基于这个前提下，学习Fragment的构建思路，可以制定下更轻量，更灵活的方案，还有很关键的一点是风险可控,避免程序出现一些无法解决的问题。


 ## 简单使用说明
 ### 1.配置
  根gradle: maven{url'https://www.jitpack.io'}
             app gradle：implementation 'com.github.cfw1992:SoundPlayer:1.0.0'
