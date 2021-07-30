/*
 * Copyright 2021 Alexi Bre
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tech.alexib.yaba.stubs

import com.benasher44.uuid.uuid4

internal const val transactionsJson = """
    [
  {
    "id": "59bf7ac6-b01f-470c-8c4a-e6c8b467c1a6",
    "accountId": "fcf23dcf-ff10-40a4-93c0-5af4add2e07b",
    "name": "CREDIT CARD 3333 PAYMENT *//",
    "type": "SPECIAL",
    "amount": 25,
    "date": "2021-07-09",
    "category": "Payment",
    "subcategory": "Credit Card",
    "isoCurrencyCode": "USD",
    "merchantName": null,
    "pending": false
  },
  {
    "id": "e15ece09-3781-4de9-8360-d6351edb8765",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "Uber 063015 SF**POOL**",
    "type": "SPECIAL",
    "amount": 5.4,
    "date": "2021-07-09",
    "category": "Travel",
    "subcategory": "Taxi",
    "isoCurrencyCode": "USD",
    "merchantName": "Uber",
    "pending": false
  },
  {
    "id": "7de2ceee-5ea6-4196-b1e7-65a9683a6b02",
    "accountId": "e8d05ad8-de28-4f6a-9963-8adae779297e",
    "name": "ACH Electronic CreditGUSTO PAY 123456",
    "type": "SPECIAL",
    "amount": 5850,
    "date": "2021-07-08",
    "category": "Transfer",
    "subcategory": "Debit",
    "isoCurrencyCode": "USD",
    "merchantName": null,
    "pending": false
  },
  {
    "id": "4d7ea616-9745-418a-9ba3-e3bcbd0acd2e",
    "accountId": "6353544f-9e4f-4040-861e-b59eea721d27",
    "name": "CD DEPOSIT .INITIAL.",
    "type": "SPECIAL",
    "amount": 1000,
    "date": "2021-07-08",
    "category": "Transfer",
    "subcategory": "Deposit",
    "isoCurrencyCode": "USD",
    "merchantName": null,
    "pending": false
  },
  {
    "id": "2557a94b-8917-4a55-ac6a-67d3fdebd6e3",
    "accountId": "50886f79-b633-4c37-925d-89d69ba6046c",
    "name": "Touchstone Climbing",
    "type": "PLACE",
    "amount": 78.5,
    "date": "2021-07-07",
    "category": "Recreation",
    "subcategory": "Gyms and Fitness Centers",
    "isoCurrencyCode": "USD",
    "merchantName": "Touchstone",
    "pending": false
  },
  {
    "id": "35f595d8-a0cf-42db-9d3b-ae52ab3811a5",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "United Airlines",
    "type": "SPECIAL",
    "amount": -500,
    "date": "2021-07-07",
    "category": "Travel",
    "subcategory": "Airlines and Aviation Services",
    "isoCurrencyCode": "USD",
    "merchantName": "United Airlines",
    "pending": false
  },
  {
    "id": "25b576fb-73f5-4c8c-b13a-8e454f1337b1",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "McDonald's",
    "type": "PLACE",
    "amount": 12,
    "date": "2021-07-06",
    "category": "Food and Drink",
    "subcategory": "Restaurants",
    "isoCurrencyCode": "USD",
    "merchantName": "McDonald's",
    "pending": false
  },
  {
    "id": "58f42352-666a-4e8b-b360-cd5a9cf527cf",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "Starbucks",
    "type": "PLACE",
    "amount": 4.33,
    "date": "2021-07-06",
    "category": "Food and Drink",
    "subcategory": "Restaurants",
    "isoCurrencyCode": "USD",
    "merchantName": "Starbucks",
    "pending": false
  },
  {
    "id": "28b30938-3703-4177-9167-1677b3c1ea5c",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "SparkFun",
    "type": "PLACE",
    "amount": 89.4,
    "date": "2021-07-05",
    "category": "Food and Drink",
    "subcategory": "Restaurants",
    "isoCurrencyCode": "USD",
    "merchantName": "Sparkfun",
    "pending": false
  },
  {
    "id": "eb4480aa-31ad-40b4-be1c-9e07bee1a47e",
    "accountId": "fcf23dcf-ff10-40a4-93c0-5af4add2e07b",
    "name": "INTRST PYMNT",
    "type": "SPECIAL",
    "amount": -4.22,
    "date": "2021-07-04",
    "category": "Transfer",
    "subcategory": "Credit",
    "isoCurrencyCode": "USD",
    "merchantName": null,
    "pending": false
  },
  {
    "id": "8a96bc55-9433-4fb3-bdff-563de6b81d28",
    "accountId": "50886f79-b633-4c37-925d-89d69ba6046c",
    "name": "United Airlines",
    "type": "SPECIAL",
    "amount": 500,
    "date": "2021-06-24",
    "category": "Travel",
    "subcategory": "Airlines and Aviation Services",
    "isoCurrencyCode": "USD",
    "merchantName": "United Airlines",
    "pending": false
  },
  {
    "id": "77a682b1-eeef-413c-a927-1d4963afd4b1",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "Uber 072515 SF**POOL**",
    "type": "SPECIAL",
    "amount": 6.33,
    "date": "2021-06-22",
    "category": "Travel",
    "subcategory": "Taxi",
    "isoCurrencyCode": "USD",
    "merchantName": "Uber",
    "pending": false
  },
  {
    "id": "5229ed02-6a38-4d60-ac88-cd68eff9fa5e",
    "accountId": "50886f79-b633-4c37-925d-89d69ba6046c",
    "name": "Tectra Inc",
    "type": "PLACE",
    "amount": 500,
    "date": "2021-06-19",
    "category": "Food and Drink",
    "subcategory": "Restaurants",
    "isoCurrencyCode": "USD",
    "merchantName": "Tectra Inc",
    "pending": false
  },
  {
    "id": "203aac70-a0ef-4dea-a453-f46919fa62b5",
    "accountId": "50886f79-b633-4c37-925d-89d69ba6046c",
    "name": "AUTOMATIC PAYMENT - THANK",
    "type": "SPECIAL",
    "amount": 2078.5,
    "date": "2021-06-18",
    "category": "Payment",
    "subcategory": null,
    "isoCurrencyCode": "USD",
    "merchantName": null,
    "pending": false
  },
  {
    "id": "cd785ba4-e02d-4ee0-98d6-6a7b8768efe4",
    "accountId": "50886f79-b633-4c37-925d-89d69ba6046c",
    "name": "KFC",
    "type": "PLACE",
    "amount": 500,
    "date": "2021-06-18",
    "category": "Food and Drink",
    "subcategory": "Restaurants",
    "isoCurrencyCode": "USD",
    "merchantName": "KFC",
    "pending": false
  },
  {
    "id": "1f1b900c-d67a-47a9-b120-8d74998ed4e4",
    "accountId": "50886f79-b633-4c37-925d-89d69ba6046c",
    "name": "Madison Bicycle Shop",
    "type": "PLACE",
    "amount": 500,
    "date": "2021-06-18",
    "category": "Shops",
    "subcategory": "Sporting Goods",
    "isoCurrencyCode": "USD",
    "merchantName": "Madison Bicycle Shop",
    "pending": false
  },
  {
    "id": "49e57f9f-7198-4061-90b4-e677cf1d92f3",
    "accountId": "fcf23dcf-ff10-40a4-93c0-5af4add2e07b",
    "name": "CREDIT CARD 3333 PAYMENT *//",
    "type": "SPECIAL",
    "amount": 25,
    "date": "2021-06-09",
    "category": "Payment",
    "subcategory": "Credit Card",
    "isoCurrencyCode": "USD",
    "merchantName": null,
    "pending": false
  },
  {
    "id": "354b384d-1d18-4097-9de3-4b37163d0a75",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "Uber 063015 SF**POOL**",
    "type": "SPECIAL",
    "amount": 5.4,
    "date": "2021-06-09",
    "category": "Travel",
    "subcategory": "Taxi",
    "isoCurrencyCode": "USD",
    "merchantName": "Uber",
    "pending": false
  },
  {
    "id": "5049c848-0f0f-4b11-a2d2-1b798b1f5cc9",
    "accountId": "e8d05ad8-de28-4f6a-9963-8adae779297e",
    "name": "ACH Electronic CreditGUSTO PAY 123456",
    "type": "SPECIAL",
    "amount": 5850,
    "date": "2021-06-08",
    "category": "Transfer",
    "subcategory": "Debit",
    "isoCurrencyCode": "USD",
    "merchantName": null,
    "pending": false
  },
  {
    "id": "f28f44c5-d9dd-4860-ba94-e821fc1866b4",
    "accountId": "6353544f-9e4f-4040-861e-b59eea721d27",
    "name": "CD DEPOSIT .INITIAL.",
    "type": "SPECIAL",
    "amount": 1000,
    "date": "2021-06-08",
    "category": "Transfer",
    "subcategory": "Deposit",
    "isoCurrencyCode": "USD",
    "merchantName": null,
    "pending": false
  },
  {
    "id": "6cffc804-87ae-42ba-a882-63a5c771ab49",
    "accountId": "50886f79-b633-4c37-925d-89d69ba6046c",
    "name": "Touchstone Climbing",
    "type": "PLACE",
    "amount": 78.5,
    "date": "2021-06-07",
    "category": "Recreation",
    "subcategory": "Gyms and Fitness Centers",
    "isoCurrencyCode": "USD",
    "merchantName": "Touchstone",
    "pending": false
  },
  {
    "id": "f9049f3a-6cc4-45ad-a175-8c34ff80d559",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "United Airlines",
    "type": "SPECIAL",
    "amount": -500,
    "date": "2021-06-07",
    "category": "Travel",
    "subcategory": "Airlines and Aviation Services",
    "isoCurrencyCode": "USD",
    "merchantName": "United Airlines",
    "pending": false
  },
  {
    "id": "4df56055-0cc8-44fd-a8b3-befbf6409481",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "McDonald's",
    "type": "PLACE",
    "amount": 12,
    "date": "2021-06-06",
    "category": "Food and Drink",
    "subcategory": "Restaurants",
    "isoCurrencyCode": "USD",
    "merchantName": "McDonald's",
    "pending": false
  },
  {
    "id": "5baa2a71-ed06-4bfe-aadc-03c635c311ef",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "Starbucks",
    "type": "PLACE",
    "amount": 4.33,
    "date": "2021-06-06",
    "category": "Food and Drink",
    "subcategory": "Restaurants",
    "isoCurrencyCode": "USD",
    "merchantName": "Starbucks",
    "pending": false
  },
  {
    "id": "cc5d3a7a-ad19-46cb-a572-a7084f9e7284",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "SparkFun",
    "type": "PLACE",
    "amount": 89.4,
    "date": "2021-06-05",
    "category": "Food and Drink",
    "subcategory": "Restaurants",
    "isoCurrencyCode": "USD",
    "merchantName": "Sparkfun",
    "pending": false
  },
  {
    "id": "0399e741-1d8b-4dc0-a4a5-74e330dcce1c",
    "accountId": "fcf23dcf-ff10-40a4-93c0-5af4add2e07b",
    "name": "INTRST PYMNT",
    "type": "SPECIAL",
    "amount": -4.22,
    "date": "2021-06-04",
    "category": "Transfer",
    "subcategory": "Credit",
    "isoCurrencyCode": "USD",
    "merchantName": null,
    "pending": false
  },
  {
    "id": "e2ba862a-6f05-42d0-8507-9a4868cb9a04",
    "accountId": "50886f79-b633-4c37-925d-89d69ba6046c",
    "name": "United Airlines",
    "type": "SPECIAL",
    "amount": 500,
    "date": "2021-05-25",
    "category": "Travel",
    "subcategory": "Airlines and Aviation Services",
    "isoCurrencyCode": "USD",
    "merchantName": "United Airlines",
    "pending": false
  },
  {
    "id": "22f7de04-5c1e-4b41-bb6e-96ed5234921a",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "Uber 072515 SF**POOL**",
    "type": "SPECIAL",
    "amount": 6.33,
    "date": "2021-05-23",
    "category": "Travel",
    "subcategory": "Taxi",
    "isoCurrencyCode": "USD",
    "merchantName": "Uber",
    "pending": false
  },
  {
    "id": "c0e503d8-e1cf-480b-b72c-09fc527d2d9b",
    "accountId": "50886f79-b633-4c37-925d-89d69ba6046c",
    "name": "Tectra Inc",
    "type": "PLACE",
    "amount": 500,
    "date": "2021-05-20",
    "category": "Food and Drink",
    "subcategory": "Restaurants",
    "isoCurrencyCode": "USD",
    "merchantName": "Tectra Inc",
    "pending": false
  },
  {
    "id": "735a2996-0142-45d0-9c89-aee2b0e21b01",
    "accountId": "50886f79-b633-4c37-925d-89d69ba6046c",
    "name": "AUTOMATIC PAYMENT - THANK",
    "type": "SPECIAL",
    "amount": 2078.5,
    "date": "2021-05-19",
    "category": "Payment",
    "subcategory": null,
    "isoCurrencyCode": "USD",
    "merchantName": null,
    "pending": false
  },
  {
    "id": "5fdd2f8c-60a9-4e86-8daa-bed698f283e9",
    "accountId": "50886f79-b633-4c37-925d-89d69ba6046c",
    "name": "KFC",
    "type": "PLACE",
    "amount": 500,
    "date": "2021-05-19",
    "category": "Food and Drink",
    "subcategory": "Restaurants",
    "isoCurrencyCode": "USD",
    "merchantName": "KFC",
    "pending": false
  },
  {
    "id": "0556f3e6-8e52-4ae7-b0c6-933076fd3383",
    "accountId": "50886f79-b633-4c37-925d-89d69ba6046c",
    "name": "Madison Bicycle Shop",
    "type": "PLACE",
    "amount": 500,
    "date": "2021-05-19",
    "category": "Shops",
    "subcategory": "Sporting Goods",
    "isoCurrencyCode": "USD",
    "merchantName": "Madison Bicycle Shop",
    "pending": false
  },
  {
    "id": "6d6296c9-2bdb-44ab-8d8a-52c5f96531a6",
    "accountId": "fcf23dcf-ff10-40a4-93c0-5af4add2e07b",
    "name": "CREDIT CARD 3333 PAYMENT *//",
    "type": "SPECIAL",
    "amount": 25,
    "date": "2021-05-10",
    "category": "Payment",
    "subcategory": "Credit Card",
    "isoCurrencyCode": "USD",
    "merchantName": null,
    "pending": false
  },
  {
    "id": "3712bb58-97a5-4a4e-96ed-345472e03e79",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "Uber 063015 SF**POOL**",
    "type": "SPECIAL",
    "amount": 5.4,
    "date": "2021-05-10",
    "category": "Travel",
    "subcategory": "Taxi",
    "isoCurrencyCode": "USD",
    "merchantName": "Uber",
    "pending": false
  },
  {
    "id": "4f2c9607-991a-4b60-a6bb-0bd0596f21ea",
    "accountId": "e8d05ad8-de28-4f6a-9963-8adae779297e",
    "name": "ACH Electronic CreditGUSTO PAY 123456",
    "type": "SPECIAL",
    "amount": 5850,
    "date": "2021-05-09",
    "category": "Transfer",
    "subcategory": "Debit",
    "isoCurrencyCode": "USD",
    "merchantName": null,
    "pending": false
  },
  {
    "id": "0b89df65-e756-41d2-847d-65023d3d708a",
    "accountId": "6353544f-9e4f-4040-861e-b59eea721d27",
    "name": "CD DEPOSIT .INITIAL.",
    "type": "SPECIAL",
    "amount": 1000,
    "date": "2021-05-09",
    "category": "Transfer",
    "subcategory": "Deposit",
    "isoCurrencyCode": "USD",
    "merchantName": null,
    "pending": false
  },
  {
    "id": "b8322c7a-9598-48bc-9152-9971a1b61889",
    "accountId": "50886f79-b633-4c37-925d-89d69ba6046c",
    "name": "Touchstone Climbing",
    "type": "PLACE",
    "amount": 78.5,
    "date": "2021-05-08",
    "category": "Recreation",
    "subcategory": "Gyms and Fitness Centers",
    "isoCurrencyCode": "USD",
    "merchantName": "Touchstone",
    "pending": false
  },
  {
    "id": "c85c71aa-8e06-4e28-b70b-08dcc4303907",
    "accountId": "228021f2-7fbc-4929-9c36-01e262c1e858",
    "name": "United Airlines",
    "type": "SPECIAL",
    "amount": -500,
    "date": "2021-05-08",
    "category": "Travel",
    "subcategory": "Airlines and Aviation Services",
    "isoCurrencyCode": "USD",
    "merchantName": "United Airlines",
    "pending": false
  }
]
"""

internal val detailStub = """
        {
        "id":"${uuid4()}",
        "accountId":"${uuid4()}",
            "account_id": "MkLNaqkNJASB3anarQwwUx8XxjBQ7puDjnZVp",
            "account_owner": null,
            "amount": 6.33,
            "authorized_date": null,
            "authorized_datetime": null,
            "category":"Travel",
            "subcategory": "Taxi",
            "category_id": "22016000",
            "date": "2021-06-22",
            "datetime": null,
            "isoCurrencyCode": "USD",
            "location": {
                "address": null,
                "city": null,
                "country": null,
                "lat": null,
                "lon": null,
                "postal_code": null,
                "region": null,
                "store_number": null
            },
            "institutionName":"Chase",
            "accountName":"Checking",
            "merchantName": "Uber",
            "name": "Uber 072515 SF**POOL**",
            "payment_channel": "in store",
            "accountMask":"0000",
            "payment_meta": {
                "by_order_of": null,
                "payee": null,
                "payer": null,
                "payment_method": null,
                "payment_processor": null,
                "ppd_id": null,
                "reason": null,
                "reference_number": null
            },
            "pending": false,
            "pending_transaction_id": null,
            "transaction_code": null,
            "transaction_id": "8z5jnKzjg3He9WAWr1NNIJwnpoNQRnixkqJAl",
            "type": "SPECIAL",
            "unofficial_currency_code": null
        }
""".trimIndent()
