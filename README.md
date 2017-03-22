# ASAI
Analyzing Spreadsheets with Artificial Intelligence

This program will work with spreadsheet and database formats. The program will be written in Java and will analyze all spreadsheet files (xls, xlsx, ods, csv, and a few other formats) in a collection. The program will use metadata such as the title of the file, the names of spreadsheet tabs, the length of the file, and an analysis of the file's contents to produce a report for the user. The report will be in HTML format, which will allow us to create various dynamic images which illustrate connections between files and clusters of content.

Tools that will be used for this project include:

Apache Tika (https://tika.apache.org/) - to convert files to plain text for analysis, and to extract column headers.

TensorFlow (https://www.tensorflow.org/) - library for machine intelligence. TensorFlow has the ability to perform contextual text analysis (https://research.googleblog.com/2016/08/text-summarization-with-tensorflow.html)

Mallet (http://mallet.cs.umass.edu/) - "is a Java-based package for statistical natural language processing, document classification, clustering, topic modeling, information extraction, and other machine learning applications to text."

D3.ja (https://d3js.org/) - to create data visualizations for the HTML results page, including word clouds, bubble charts and other images.

Carrot2 (http://project.carrot2.org/) - to create interactive document clusters.

Other tools (TBD) will be used to create in-depth results analysis, including time lines and cluster analysis. 

General process flow will be:

1. Analyze and enumerate directories and files, create list of files with the extensions xls, xlsx, ods, csv, and mdb. Output running process to the GUI, including progress bar and running list of directories and matching files.

2. Recurse over each file and use Apache Tika (except for csv) to extract metadata including: worksheet names, list of column headers, analysis of content (see #3), number of rows and columns, size of file, creator, date created, etc. For CSV files, process with pure Java.

3. Textual content analysis will initially be limited to creating simple word frequency lists and analyzing cell contents to identify numbers or text. Eventually AI will be used to simplify and summarize the content of each file (and each group of files). A basic scoring algorithm will be created to rank spreadsheet content extracted from a file. File name, sheet name, and column names will be weighted along with the word frequency list to create a textual summary of the file content's. Individual spreadsheet summaries will be aggregated to create a directory or transfer summary. Spreadsheets will be identified as containing mostly numbers, or mostly text. Special characters may be identified ($, %, etc.) to further classify sheets or files.

4. Report will be in HTML format and will include summarizations of all files, as well as to-be-determined graphics and reports. Word clouds, document cluster graphics, etc. might be created (possibly with D3 or other HTML tools.) Relationships between authors and timeline of files by creation or last modified date, will also be included.
