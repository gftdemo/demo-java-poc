{
  "predictions": [
    {
      "candidates": [
        {
          "author": "1",
          "content": "package com.scalesec.vulnado;\n\nimport org.springframework.boot.SpringApplication;\nimport org.springframework.boot.autoconfigure.SpringBootApplication;\nimport org.springframework.boot.web.servlet.ServletComponentScan;\n\n@ServletComponentScan\n@SpringBootApplication\npublic class VulnadoApplication {\n\n    public static void main(String[] args) {\n        Postgres.setup();\n        SpringApplication.run(VulnadoApplication.class, args);\n    }\n}"
        }
      ],
      "safetyAttributes": [
        {
          "categories": [],
          "blocked": false,
          "scores": []
        }
      ],
      "citationMetadata": [
        {
          "citations": [
            {
              "startIndex": 0,
              "endIndex": 428
            },
            {
              "license": "Apache-2.0",
              "startIndex": 0,
              "url": "https://github.com/meerasubbarao/vulnapp",
              "endIndex": 144
            },
            {
              "license": "Apache-2.0",
              "endIndex": 428,
              "url": "https://github.com/meerasubbarao/vulnapp",
              "startIndex": 158
            }
          ]
        }
      ],
      "groundingMetadata": [
        {}
      ]
    }
  ],
  "metadata": {
    "tokenMetadata": {
      "inputTokenCount": {
        "totalBillableCharacters": 1367,
        "totalTokens": 385
      },
      "outputTokenCount": {
        "totalBillableCharacters": 388,
        "totalTokens": 113
      }
    }
  }
}
