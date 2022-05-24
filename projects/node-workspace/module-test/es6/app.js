import moduleA from "./moduleA.js";
console.log(moduleA);
console.log(moduleA.moduleA_var1);
moduleA.moduleA_fun1;
console.log("");

import moduleB_default, {moduleB_var1,moduleB_fun1} from "./moduleB.js";
console.log(moduleB_default);
console.log(moduleB_var1);
moduleB_fun1();