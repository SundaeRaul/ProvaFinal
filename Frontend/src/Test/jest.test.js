import apiGetter from "./api.Getter"


describe('jest test', () => {
    
    test("deve retornar uma lista", () => {
        const result = apiGetter();
        console.log(result)
        expect(result).toBeUndefined();
    })

})