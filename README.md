# ASAI
Analyzing Spreadsheets with Artificial Intelligence

The current project will work with spreadsheet and database formats. The program will be written in Java and would use Apache Tika (https://tika.apache.org/) to identify and analyze all spreadsheet files (xls, xlsx, ods, csv, and a few other formats) in a collection. The program would use metadata such as the title of the file, the names of spreadsheet tabs, the length of the file, and possibly an analysis of the file's contents, to produce a report for the processing archivist. The report would be in HTML format, which would allow us to create various images which illustrate connections between files and clusters of content.

Tools that will be used for this project include Google's TensorFlow (https://www.tensorflow.org/) library for machine intelligence. TensorFlow has the
ability to perform contextual text analysis (https://research.googleblog.com/2016/08/text-summarization-with-tensorflow.html)
Other tools will perform image creation, such as the cluster analysis I mentioned above, and other, simpler things, like word clouds.

General process flow will be:

1. Analyze and enumerate directories and files, create list of files with the extensions xls, xlsx, ods, csv, and mdb. Output running process to the GUI, including progress bar and running list of directories and matching files.

2. Recurse over each file and use Apache Tika (except for csv) to extract metadata including: worksheet names, list of column headers, analysis of content (see #3), number of rows and columns, size of file, creator, date created, etc. For CSV files, process with pure Java.

3. Textual content analysis will initially be limited to creating simple word frequency lists and analyzing cell contents to identify numbers or text. Eventually AI will be used to simplify and summarize the content of each file (and each group of files).

4. Report will be in HTML format and will include summarizations of all files, as well as to-be-determined graphics and reports. Word clouds, document cluster graphics, etc. might be created (possibly with D3 or other HTML tools.) Relationships between authors and timeline of files by creation or last modified date, will also be included.
