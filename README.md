# Application Overview

<p>Co-developed by John Riordan and Joshua Vasquez-Ruiz, this application was produced for the course CS514 taught by Dr. David Wolber at the University of San Francisco. Assigned as the course's third project, this project was designed to leverage the capabilities that Vaadin, an open-source web application development platform for Java, offered to develop an Generative AI application using OpenAI.</p>

<p>The focus of this application was to create a chat bot that was capable of providing insight into occupational health regulations and requirements covered by Title 29 of the Code of Federal Regulations Part 1910. In PDF form, this collection of regulations that covers the Occupational Safety and Health Act, known as OSHA, spans over 600 pages. Documents such as this, if paired with a chat bot that could provide insight into these large information-bases, would be immensely useful. This tool would not only be useful for teams hiring new Environmental Health & Safety Managers that have yet to get the lay of the land of the workplaces they will be overseeing the operations of, but also an amazing source of clarification for the supervisors and the very workers belonging to workplaces that are doing the work itself. This tool can bridge the gap in understanding between groups of varying expertise by taking in user questions and translating from these large information-bases into a form that the user can tailor that is effective for them. In turn, this can effectively improve cross-functional communication and processes by augmenting the user's information-acquisition and understanding abilities.</p>

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
