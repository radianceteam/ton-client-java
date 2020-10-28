package com.radiance.tonclient;

import java.util.concurrent.CompletableFuture;

/**
 *   BOC manipulation module.
 */
public class Boc {

    private TONContext context;

    public Boc(TONContext context) {
        this.context = context;
    }

  /**
   *  Parses message boc into a JSON <p> JSON structure is compatible with GraphQL API message object
   *
   * @param boc  BOC encoded as base64
   */
    public CompletableFuture<String> parseMessage(String boc) {
        return context.requestJSON("boc.parse_message", "{\"boc\":\""+boc+"\"}")
            .thenApply(json -> json.findValue("parsed").asText());
    }

  /**
   *  Parses transaction boc into a JSON <p> JSON structure is compatible with GraphQL API transaction object
   *
   * @param boc  BOC encoded as base64
   */
    public CompletableFuture<String> parseTransaction(String boc) {
        return context.requestJSON("boc.parse_transaction", "{\"boc\":\""+boc+"\"}")
            .thenApply(json -> json.findValue("parsed").asText());
    }

  /**
   *  Parses account boc into a JSON <p> JSON structure is compatible with GraphQL API account object
   *
   * @param boc  BOC encoded as base64
   */
    public CompletableFuture<String> parseAccount(String boc) {
        return context.requestJSON("boc.parse_account", "{\"boc\":\""+boc+"\"}")
            .thenApply(json -> json.findValue("parsed").asText());
    }

  /**
   *  Parses block boc into a JSON <p> JSON structure is compatible with GraphQL API block object
   *
   * @param boc  BOC encoded as base64
   */
    public CompletableFuture<String> parseBlock(String boc) {
        return context.requestJSON("boc.parse_block", "{\"boc\":\""+boc+"\"}")
            .thenApply(json -> json.findValue("parsed").asText());
    }

  /**
   * 
   *
   * @param blockBoc  Key block BOC encoded as base64
   */
    public CompletableFuture<String> getBlockchainConfig(String blockBoc) {
        return context.requestJSON("boc.get_blockchain_config", "{\"block_boc\":\""+blockBoc+"\"}")
            .thenApply(json -> json.findValue("config_boc").asText());
    }

}
