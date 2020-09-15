### Voting app

#### _> Work in progress <_

##### This application persists the votes and uses a queue for result divulgation

##### To-Dos: 
* Correct conflictual dependencies of javax and RESTeasy
* Add swagger configuration
* Finalize upScript

#### Technologies
* Docker
* RabbitMq
* Rest
* Postgres SQL
* Jboss server
* Hibernate

### Objectives
* This solution must be executed in the cloud and promote the following functionalities through
a REST API:
   * Register a new agenda
   * Open a voting session on an agenda (the voting session must be open for one
time determined in the opening call or 1 minute by default)
   * Receive votes from members on agendas (votes are only 'Yes' / 'No'. Each
member is identified by a unique id and can vote only once per agenda)
   * Count the votes and give the result of the vote on the agenda
   
  1 - Integration with external systems
   * Integrate with a system that verifies, from the member's CPF, if he can
vote
     * GET https://user-info.herokuapp.com/users/{cpf}
     * If the CPF is invalid, the API will return HTTP Status 404 (Not found).
You can use CPF generators to generate valid CPFs
     * If the CPF is valid, the API will return if the user can (ABLE_TO_VOTE) or cannot (UNABLE_TO_VOTE) perform the operation

  2 - Messaging and queues
   * The voting result needs to be informed for the rest of the platform, this should preferably be done through messaging.
When the voting session closes, post a message with the voting result

  3 - Performance
   * Imagine that your application can be used in scenarios that have hundreds of thousands of votes. She must behave in a performative way in these scenarios
     * Performance tests are a good way to guarantee and observe how your application behaves

  4 - API versioning
   * How would you version your application's API? What strategy to use?
 
#### How to run
* To run and start everything just open a Terminal on root folder and type: ```./upScript.sh```