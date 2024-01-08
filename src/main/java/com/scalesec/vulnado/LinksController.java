{
  "predictions": [
    {
      "groundingMetadata": [
        {}
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
              "endIndex": 501,
              "startIndex": 99
            },
            {
              "endIndex": 501,
              "url": "https://github.com/meerasubbarao/vulnapp",
              "startIndex": 99,
              "license": "Apache-2.0"
            }
          ]
        }
      ],
      "candidates": [
        {
          "author": "1",
          "content": "package com.scalesec.vulnado;\n\nimport java.util.List;\nimport java.io.IOException;\n\n@RestController\npublic class LinksController {\n\n    @RequestMapping(value = \"/links\", produces = \"application/json\")\n    List\u003cString\u003e links(@RequestParam String url) throws IOException {\n        return LinkLister.getLinks(url);\n    }\n\n    @RequestMapping(value = \"/links-v2\", produces = \"application/json\")\n    List\u003cString\u003e linksV2(@RequestParam String url) throws BadRequest {\n        return LinkLister.getLinksV2(url);\n    }\n}"
        }
      ]
    }
  ],
  "metadata": {
    "tokenMetadata": {
      "outputTokenCount": {
        "totalTokens": 149,
        "totalBillableCharacters": 424
      },
      "inputTokenCount": {
        "totalTokens": 526,
        "totalBillableCharacters": 1828
      }
    }
  }
}
