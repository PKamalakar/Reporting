/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.cn.reporting.rest;

import org.apache.fineract.cn.anubis.annotation.AcceptedTokenType;
import org.apache.fineract.cn.anubis.annotation.Permittable;
import org.apache.fineract.cn.reporting.ServiceConstants;
import org.apache.fineract.cn.reporting.api.domain.*;
import org.apache.fineract.cn.reporting.internal.service.CommonApiService;
import org.apache.fineract.cn.reporting.internal.service.TransactionSummaryApiService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report1")
public class TransactionSummaryApiRestController {

  private final Logger logger;
  private final TransactionSummaryApiService transactionSummaryApiService;


  @Autowired
  public TransactionSummaryApiRestController(@Qualifier(ServiceConstants.LOGGER_NAME) final Logger logger,
                                             final TransactionSummaryApiService transactionSummaryApiService) {
    super();
    this.logger = logger;
    this.transactionSummaryApiService = transactionSummaryApiService;
  }

  @Permittable(value= AcceptedTokenType.GUEST)
  @RequestMapping(
          value = "/get-shg-meeting",
          method = RequestMethod.POST,
          consumes = MediaType.ALL_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public
  @ResponseBody
  ResponseEntity<List<TransactionSummary>> fetchShgMeetingSummaryList(@RequestBody TransactionSummaryRequest transactionSummaryRequest) {
    return ResponseEntity.ok(
            this.transactionSummaryApiService.fetchShgTransactionSummaryList(transactionSummaryRequest));
  }

  @Permittable(value= AcceptedTokenType.GUEST)
  @RequestMapping(
          value = "/get-shg-saving",
          method = RequestMethod.POST,
          consumes = MediaType.ALL_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public
  @ResponseBody
  ResponseEntity<List<TransactionSummary>> fetchShgSavingSummaryList(@RequestBody TransactionSummaryRequest transactionSummaryRequest) {
    return ResponseEntity.ok(
            this.transactionSummaryApiService.fetchShgTransactionSummaryList(transactionSummaryRequest));
  }
  @Permittable(value= AcceptedTokenType.GUEST)
  @RequestMapping(
          value = "/get-shg-loan",
          method = RequestMethod.POST,
          consumes = MediaType.ALL_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public
  @ResponseBody
  ResponseEntity<List<TransactionSummary>> fetchShgLoanSummaryList(@RequestBody TransactionSummaryRequest transactionSummaryRequest) {
    return ResponseEntity.ok(
            this.transactionSummaryApiService.fetchShgTransactionSummaryList(transactionSummaryRequest));
  }

  @Permittable(value= AcceptedTokenType.GUEST)
  @RequestMapping(
          value = "/get-vo-meeting",
          method = RequestMethod.POST,
          consumes = MediaType.ALL_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public
  @ResponseBody
  ResponseEntity<List<VoTransactionSummary>> fetchVoMeetingSummaryList(@RequestBody TransactionSummaryRequest transactionSummaryRequest) {
    return ResponseEntity.ok(
            this.transactionSummaryApiService.fetchVoTransactionSummaryList(transactionSummaryRequest));
  }

  @Permittable(value= AcceptedTokenType.GUEST)
  @RequestMapping(
          value = "/get-vo-saving",
          method = RequestMethod.POST,
          consumes = MediaType.ALL_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public
  @ResponseBody
  ResponseEntity<List<VoTransactionSummary>> fetchVoSavingSummaryList(@RequestBody TransactionSummaryRequest transactionSummaryRequest) {
    return ResponseEntity.ok(
            this.transactionSummaryApiService.fetchVoTransactionSummaryList(transactionSummaryRequest));
  }
  @Permittable(value= AcceptedTokenType.GUEST)
  @RequestMapping(
          value = "/get-vo-loan",
          method = RequestMethod.POST,
          consumes = MediaType.ALL_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public
  @ResponseBody
  ResponseEntity<List<VoTransactionSummary>> fetchVoLoanSummaryList(@RequestBody TransactionSummaryRequest transactionSummaryRequest) {
    return ResponseEntity.ok(
            this.transactionSummaryApiService.fetchVoTransactionSummaryList(transactionSummaryRequest));
  }

}