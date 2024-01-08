{
  "predictions": [
    {
      "groundingMetadata": [
        {}
      ],
      "candidates": [
        {
          "content": "package com.scalesec.vulnado;\n\nimport org.springframework.web.bind.annotation.*;\nimport org.springframework.boot.autoconfigure.*;\n\n@RestController\n@EnableAutoConfiguration\npublic class CowController {\n\n    @RequestMapping(value = \"/cowsay\")\n    String cowsay(@RequestParam(defaultValue = \"I love Linux!\") String input) {\n        return Cowsay.run(input);\n    }\n}",
          "author": "1"
        }
      ],
      "citationMetadata": [
        {
          "citations": [
            {
              "endIndex": 125,
              "startIndex": 0
            },
            {
              "endIndex": 341,
              "startIndex": 132
            },
            {
              "url": "https://github.com/veracodesast1/VS1",
              "endIndex": 125,
              "license": "Apache-2.0",
              "startIndex": 0
            },
            {
              "license": "Apache-2.0",
              "url": "https://github.com/veracodesast1/VS1",
              "endIndex": 341,
              "startIndex": 132
            }
          ]
        }
      ],
      "safetyAttributes": [
        {
          "scores": [
            0.1
          ],
          "blocked": false,
          "categories": [
            "Health"
          ]
        }
      ]
    }
  ],
  "metadata": {
    "tokenMetadata": {
      "inputTokenCount": {
        "totalBillableCharacters": 1365,
        "totalTokens": 394
      },
      "outputTokenCount": {
        "totalBillableCharacters": 312,
        "totalTokens": 100
      }
    }
  }
}
