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
import org.apache.fineract.cn.reporting.internal.Error.RequestInputMissing;
import org.apache.fineract.cn.reporting.internal.exception.CustomStatus;
import org.apache.fineract.cn.reporting.internal.service.GeographicalCoverageApiService;
import org.apache.fineract.cn.reporting.internal.service.LeaderEducationApiService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/leader")
public class LeaderEducationApiRestController {


        private final Logger logger;
        private final LeaderEducationApiService leaderEducationApiService;


        @Autowired
        public LeaderEducationApiRestController(@Qualifier(ServiceConstants.LOGGER_NAME) final Logger logger,
                                                     final LeaderEducationApiService leaderEducationApiService) {
            super();
            this.logger = logger;
            this.leaderEducationApiService = leaderEducationApiService;
        }
    @Permittable(value= AcceptedTokenType.GUEST)
    @RequestMapping(
            value = "/leader-education",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public
    @ResponseBody
    ResponseEntity<List<LeaderEducationResponse>> getLeaderEducationData(@RequestBody LeaderEducationRequest request,
                                                                @RequestHeader Map<String, String> headers) {
        if(headers.get("X-Tenant-Identifier")==null){
            this.logger.error(CustomStatus.REQUEST_INPUT_NOT_PRESENT_MSG + "{X-Tenant-Identifier}");
            throw new RequestInputMissing(CustomStatus.REQUEST_INPUT_NOT_PRESENT_MSG + "{X-Tenant-Identifier}");
        }
        String location_type = request.getLocation_type();
        String date_to = request.getDate_to();
        String date_from = request.getDate_from();
        String state_id = request.getState_id();
        String district_id = request.getDistrict_id();
        String block_id = request.getBlock_id();
        String tenantIdentifier = headers.get("X-Tenant-Identifier");
        return ResponseEntity.ok(
                this.leaderEducationApiService.getLeaderEducationData(location_type,date_to,date_from, state_id, district_id, block_id, tenantIdentifier));
    }

        @Permittable(value= AcceptedTokenType.GUEST)
        @RequestMapping(
                value = "/leader-liveliHood",
                method = RequestMethod.POST,
                consumes = MediaType.ALL_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE
        )
        public
        @ResponseBody
        ResponseEntity<List<LeaderLiveliHoodResponse>> getLeaderData(@RequestBody LeaderLiveliHoodRequest request,
                                                                  @RequestHeader Map<String, String> headers) {
            if(headers.get("X-Tenant-Identifier")==null){
                this.logger.error(CustomStatus.REQUEST_INPUT_NOT_PRESENT_MSG + "{X-Tenant-Identifier}");
                throw new RequestInputMissing(CustomStatus.REQUEST_INPUT_NOT_PRESENT_MSG + "{X-Tenant-Identifier}");
            }
            String location_type = request.getLocation_type();
            String date_to = request.getDate_to();
            String date_from = request.getDate_from();
            String state_id = request.getState_id();
            String district_id = request.getDistrict_id();
            String block_id = request.getBlock_id();
            String tenantIdentifier = headers.get("X-Tenant-Identifier");
            return ResponseEntity.ok(
                    this.leaderEducationApiService.getLeaderData(location_type,date_to,date_from, state_id, district_id, block_id, tenantIdentifier));
        }

    }