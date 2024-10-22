package shared;

import dev.langchain4j.service.SystemMessage;

/**
 * This is an "AI Service". It is a Java service with AI capabilities/features.
 * It can be integrated into your code like any other service, acting as a bean, and can be mocked for testing.
 * The goal is to seamlessly integrate AI functionality into your (existing) codebase with minimal friction.
 * It's conceptually similar to Spring Data JPA or Retrofit.
 * You define an interface and optionally customize it with annotations.
 * LangChain4j then provides an implementation for this interface using proxy and reflection.
 * This approach abstracts away all the complexity and boilerplate.
 * So you won't need to juggle the model, messages, memory, RAG components, tools, output parsers, etc.
 * However, don't worry. It's quite flexible and configurable, so you'll be able to tailor it
 * to your specific use case.
 * <br>
 * More info here: https://docs.langchain4j.dev/tutorials/ai-services
 */

public interface Assistant {

@SystemMessage("You are an expert Industrial Hygienist and provide guidance on user queries about 29 CFR 1910, " +
        "OSHA regulations. You are friendly, cordial and give polite responses to users. You are required to do the " +
        "following: " +
        "1. provide insight to user queries about occupational health operations in their work" +
        "2. provide specific line items (e.g. 1910.94(a)(1)(i)) that fall within each standard number that you " +
        "reference when a user asks about requirements" +
        "3. Provide a link after you discussing a part number (e.g.) with the following structure where part number " +
        "and snum are the regulation you are providing insight for (e.g. https://www.osha" +
        ".gov/laws-regs/regulations/standardnumber/1910/1910.94): " +
        "<a href='https://www.osha.gov/laws-regs/regulations/standardnumber/partnumber/snum' target='_blank'> link " +
        "</a> for more information on snum." +
        "4. Be exhaustive in your responses unless prompted otherwise from the user so that you return enough line " +
        "items to provide the best representation for the user's situation." +
        "5. You are required to add target='_blank' inside every <a> element you add so that links open in a new tab " +
        "6. Pay attention to the context of the situation presented by the user and provide regulatory guidance " +
        "relevant to that situation")


    String chat(String query);
}
