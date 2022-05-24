console.log("app runngin...")
const moduleA = require("./moduleA");

console.group("./commonjs/moduleA 사용");
console.log(moduleA)
console.log(moduleA.moduleA_var1);
moduleA.moduleA_fun1();
console.groupEnd();
console.log("");

const moduleB = require("./moduleB");
console.log(moduleB);
console.log(moduleB.moduleB_var1);
moduleB.moduleB_fun1();
console.log("");

const { moduleB_var2, moduleB_fun2 } = require("./moduleB");
console.log(moduleB_var2);
moduleB_fun2();