# Federal Regulations Expert Assistant (an OpenAI RAG Application)

### Application Overview

<p>Co-developed by John Riordan and Joshua Vasquez-Ruiz, this application was produced for the course CS514 taught by Dr. David Wolber at the University of San Francisco. Assigned as the course's third project, this project was designed to leverage the capabilities that Vaadin, an open-source web application development platform for Java, offered to develop an Generative AI application using OpenAI.</p>


<p>The focus of this application was to create a chat bot that was capable of providing insight into occupational health regulations and requirements covered by Title 29 of the Code of Federal Regulations Part 1910. In PDF form, this collection of regulations that covers the Occupational Safety and Health Act, known as OSHA, spans over 600 pages. Documents such as this, if paired with a chat bot that could provide insight into these large information-bases, would be immensely useful. This tool would not only be useful for teams hiring new Environmental Health & Safety Managers that have yet to get the lay of the land of the workplaces they will be overseeing the operations of, but also an amazing source of clarification for the supervisors and the very workers belonging to workplaces that are doing the work itself. This tool can bridge the gap in understanding between groups of varying expertise by taking in user questions and translating from these large information-bases into a form that the user can tailor that is effective for them. In turn, this can effectively improve cross-functional communication and processes by augmenting the user's information-acquisition and understanding abilities.</p>

### Project Functionality

<p>The functionality of this app composes of a chat window with a message input and submit button for the user to type a prompt and submit it with. Adjacent to this is a clear chat button that the user can click to erase the chat history for any new queries. In response to new user text being submitted, the assistant's content retriever searches the federal document that has loaded, segmented, and embedded for a response to the user's query. </p>

### Project Rubric
<table>
<thead>
<tr>
<td>Specifications (Base Project) </td>
<td>Deductions</td>
<td>Points</td>
<td>Notes</td>
</tr>
<tr>
<td>Message list and message input provided in Vaadin view</td>
<td></td>
<td>10</td>
<td></td>
</tr>
<tr>
<td>Clear chat button present and works as specified</td>
<td></td>
<td>10</td>
<td></td>
</tr>
<tr>
<td>When submitted, user message and assistant message added to message list in correct order</td>
<td></td>
<td>20</td>
<td></td>
</tr>
<tr>
<td>OpenAI assistant respond to user query and responds with reasonable answer</td>
<td></td>
<td>40</td>
<td></td>
</tr>
<tr>
<td>Follow-up questioning yields reasonable responses and conversation can progress with further user questioning </td>
<td></td>
<td>10</td>
<td></td>
</tr>
<tr>
<td><strong>Extra Credit: </strong>OpenAI assistant leverages content retrieval to search loaded document(s) and responses are unique to document</td>
<td></td>
<td>15</td>
<td></td>
</tr>

</thead>
</table>



<hr>

## Running the Application
There are two ways to run the application :  using `mvn spring-boot:run` or by running the `Application` class directly from the IDE. Any IDE of your preference,but Eclipse or Intellij IDEA is suggested.
Below are the configuration details to start the project using a `spring-boot:run` command. 

#### Intellij IDEA
- On the right side of the window, select Maven --> Plugins--> `spring-boot` --> `spring-boot:run` goal
- Optionally, you can disable tests by clicking on a `Skip Tests mode` blue button.

Clicking on the green run button will start the application.

After the application has started, the user can view the application at http://localhost:8080/ in their browser.

<hr>

<p>To test the chatbot, some relevant queries are listed below:</p>
<ul>
<li>What are regulations that you can point me to given my following situation: We have a room that we have two painting booths in that we use to spray aircraft parts. This paint contains hexavalent chromium and is the main hazard that we are concerned about. Industrial hygienists working with us have also identified they only have three breathing zone samples during our painting operations. They say that one of those breathing samples has an 8-hr TWA that is really close to something called the action level and two have 8-hr TWA’s that are close to zero. Even though all the samples are below, they still seem concerned about the one that's really close to the action level. Do we have to close painting operations until they take more sampling?<ul>
<li>Expand on the RP requirements<ul><li>What kind of medical evaluations do we need if we were to have samples with an 8-hr TWA over the OEL?<ul><li>What kind of medical tests should we receive?</li></ul></li></ul></li></ul></li>
</ul>
