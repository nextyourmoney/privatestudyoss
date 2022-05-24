//변수
const moduleA_var1 = "moduleA_var1_value";

//함수
const moduleA_fun1 = function() {
    console.log("moduleA_fun1() 실행");
}                                                  

//외부 접근 및 사용 허용
module.exports = {
    moduleA_var1,
    moduleA_fun1
};