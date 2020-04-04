describe("내 첫번쨰 테스트 ",function () {
    it('적당한 테스트 ',function (){
        expect(true).to.equal(true)
    })
    //Arrange - 처음 앱 상태를 설정
   // 사이트를접속하고 
   // 요소를 위해 질의하고 
    //Act - 실제 행동을 
   //요소와 상호작용 
    //Asssert - 실제 테스트 추정을함 
    //실제 테스트가 맞는지 추정 
    describe("실제 테스트 ",()=>{
        it("사이트 방문하고 실제로 테스트 ",()=>{
        cy.visit('https://example.cypress.io')

        // cy.contains('type')
        cy.contains('type').click()
        cy.url().should('include','/commands/actions')
            // 위치 찾아가고           타이핑 
        cy.get('.action-email').type('fake@email.com').should('have.value','fake@email.com')
    })
    })
})