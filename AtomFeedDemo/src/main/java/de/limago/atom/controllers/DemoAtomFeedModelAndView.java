package de.limago.atom.controllers;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

import com.rometools.rome.feed.atom.Content;
import com.rometools.rome.feed.atom.Entry;
import com.rometools.rome.feed.atom.Feed;
import com.rometools.rome.feed.atom.Link;
import com.rometools.rome.feed.atom.Person;
import com.rometools.rome.feed.synd.SyndPerson;

import de.limago.atom.services.TryService;
import de.limago.atom.services.models.TryModel;

@Component()
@Scope("prototype")
public class DemoAtomFeedModelAndView extends AbstractAtomFeedView {
	private final TryService tryService;

	@Autowired
	public DemoAtomFeedModelAndView(final TryService tryService) {
		this.tryService = tryService;
	}

	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Feed feed, HttpServletRequest request) {
		feed.setId("https://github.com/mploed/event-driven-spring-boot/credit-decision");
		feed.setTitle("Approved Credit Applications");
		List<Link> alternateLinks = new ArrayList<>();
		Link link = new Link();
		link.setRel("self");
		link.setHref(baseUrl(request) + "feed");
		alternateLinks.add(link);
		List<SyndPerson> authors = new ArrayList<SyndPerson>();
		Person person = new Person();
		person.setName("Jo Wagner");
		authors.add(person);
		feed.setAuthors(authors);

		feed.setAlternateLinks(alternateLinks);
		feed.setUpdated(new Date());
		Content subtitle = new Content();
		subtitle.setValue("List of all Demo Items");
		feed.setSubtitle(subtitle);
	}

	private String baseUrl(HttpServletRequest request) {
		return String.format("%s://%s:%d%s/", request.getScheme(), request.getServerName(), request.getServerPort(),
				request.getContextPath());
	}

	@Override
	protected List<Entry> buildFeedEntries(Map<String, Object> model, HttpServletRequest request,
	                                       HttpServletResponse response) throws Exception {

		List<Entry> entries = new ArrayList<Entry>();
		List<TryModel> decisionMemos = tryService.createModels();

		for (TryModel o : decisionMemos) {
			Entry entry = new Entry();
			entry.setId("https://github.com/mploed/event-driven-spring-boot/decision-memo/" + o.getId());
			entry.setUpdated(Date.from( o.getTimestamp().atZone( ZoneId.systemDefault()).toInstant()));
			entry.setTitle("Approved Decision " + o.getId());
			List<Content> contents = new ArrayList<Content>();
			Content content = new Content();
			content.setSrc(baseUrl(request) + "credit-decision/rest/" + o.getId());
			content.setType("application/json");
			contents.add(content);
			entry.setContents(contents);
			Content summary = new Content();
			summary.setValue(o.getId());
			entry.setSummary(summary);
			entries.add(entry);
		}

		return entries;
	}
}
